package com.orange.XRDigitalMarketing.controllers;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orange.XRDigitalMarketing.entities.Client;
import com.orange.XRDigitalMarketing.entities.Ticket;
import com.orange.XRDigitalMarketing.entities.User;
import com.orange.XRDigitalMarketing.enumeration.UserRole;
import com.orange.XRDigitalMarketing.exceptions.TicketDuplicatedException;
import com.orange.XRDigitalMarketing.exceptions.TicketNotFoundException;
import com.orange.XRDigitalMarketing.repos.UserRepo;
import com.orange.XRDigitalMarketing.services.IAdminService;
import com.orange.XRDigitalMarketing.services.IClientService;
import com.orange.XRDigitalMarketing.services.ITicketService;
import com.orange.XRDigitalMarketing.utils.Login;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping("/api/v1/admin")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {


    private final IAdminService adminService;
    private final ITicketService ticketService;
    private final IClientService clientService;
    private final UserRepo userRepo;

    public AdminController(IAdminService adminService, ITicketService ticketService, IClientService clientService, UserRepo userRepo) {
        this.adminService = adminService;
        this.ticketService = ticketService;
        this.clientService = clientService;
        this.userRepo = userRepo;
    }

    @PostMapping("/loginAdmin")
    public ResponseEntity<?> login(@RequestBody Login login){
        return adminService.login(login);
    }

    @GetMapping("/tickets")
    List<Ticket> loadAllTickets(){
        return ticketService.loadAllTickets();

    }
    @GetMapping("/tickets/{id}")
    public Ticket getTicket(@PathVariable Long id){
        return ticketService.getTicket(id);
    }
    @GetMapping("/clients")
    List<Client> getClients(){
        return clientService.getClients();
    }

    @GetMapping("/{id}")
    ResponseEntity<Ticket> loadTicket(@PathVariable Long id){
        return ticketService.loadTicket(id);
    }
    @PostMapping("/")
    ResponseEntity<?> createTicket(@RequestBody Ticket ticket) throws TicketDuplicatedException {
        return ticketService.createTicket(ticket);
    }

    @PutMapping("/")
    ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket) throws TicketNotFoundException {
        return ticketService.updateTicket(ticket);
    }

    @DeleteMapping("/{id}")
    Long removeTicket(@PathVariable Long id) throws TicketNotFoundException {
        return ticketService.removeTicket(id);
    }



    @GetMapping("/users")
    ResponseEntity<List<Client>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(clientService.getClients());
    }

    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if(authorizationHeader != null & authorizationHeader.startsWith("Bearer ")) {
        try {
            String refresh_token = authorizationHeader.substring ("Bearer ".length());
            Algorithm algorithm = Algorithm. HMAC256 ("secret".getBytes ());
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = verifier.verify(refresh_token);
            String email = decodedJWT.getSubject();
            User user = userRepo.findByEmail(email);
            String access_token = JWT.create()
                    .withSubject(user.getEmail())
                    .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                    .withIssuer(request.getRequestURI().toString())
                    .withClaim("roles", Collections.singletonList(user.getUserRole()))
                    .sign(algorithm);
            Map<String, String> tokens = new HashMap<>();
            tokens.put("access_token", access_token);
            tokens.put("refresh_token", refresh_token);
            response.setContentType (APPLICATION_JSON_VALUE);
            new ObjectMapper().writeValue (response.getOutputStream(), tokens);

    }
        catch (Exception exception){
            response.setHeader( "error", exception.getMessage ());
            response.setStatus (FORBIDDEN.value ());
//response.sendError (FORBIDDEN.value());
            Map<String, String> error = new HashMap<>();
            error.put("error_message", exception.getMessage ());
            response.setContentType(APPLICATION_JSON_VALUE);
            new ObjectMapper ().writeValue (response.getOutputStream(), error);
        }
        }
        else {
            throw new RuntimeException("Refresh token is missing");
        }
}}
