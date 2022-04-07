package com.orange.XRDigitalMarketing.controllers;


import com.orange.XRDigitalMarketing.entities.Client;
import com.orange.XRDigitalMarketing.entities.Ticket;
import com.orange.XRDigitalMarketing.exceptions.CartCustomException;
import com.orange.XRDigitalMarketing.exceptions.ClientNotFoundException;
import com.orange.XRDigitalMarketing.exceptions.PlaceOrderCustomException;
import com.orange.XRDigitalMarketing.response.CartResponse;
import com.orange.XRDigitalMarketing.response.ServerResponse;
import com.orange.XRDigitalMarketing.services.IClientService;
import com.orange.XRDigitalMarketing.services.RegistrationService;
import com.orange.XRDigitalMarketing.utils.Login;
import com.orange.XRDigitalMarketing.utils.RegistrationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RequestMapping("/api/v1/client")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {
    private final IClientService clientService;
    private final RegistrationService registrationService;

    public ClientController(IClientService clientService, RegistrationService registrationService) {
        this.clientService = clientService;
        this.registrationService = registrationService;
    }

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody Login login){
        return clientService.login(login);
    }

    @PostMapping("/registration")
    String register(@RequestBody RegistrationRequest request) throws Exception {
        return registrationService.register(request);
    }
    @GetMapping(path = "/registration/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

    @GetMapping(path = "/{email}")
    public Client getClient(@PathVariable String email) throws ClientNotFoundException {
        return clientService.getClient(email);
    }

    @PostMapping("/acheter-ticket")
    public Ticket acheterTicket(Long id , int nbrTicket,Ticket ticket) throws Exception {
        return clientService.acheterTicket(id,nbrTicket,ticket);
    }


    @GetMapping("/addToCart")
    public ResponseEntity<ServerResponse> addToCart(@RequestParam(name = "id") Long ticketID , Authentication authentication) throws ClientNotFoundException, CartCustomException {

        return clientService.addToCart(ticketID,authentication);
    }

    @GetMapping("/viewCart")
    public ResponseEntity<CartResponse> viewCart(Authentication authentication) throws CartCustomException {
        return clientService.viewCart(authentication);
    }

    @PutMapping("/updateCart")
    public ResponseEntity<CartResponse> updateCart(@RequestBody HashMap<String,String> cart , Authentication auth) throws CartCustomException {
        return clientService.updateCart(cart, auth);
    }
    @DeleteMapping("/delCart")
    public ResponseEntity<CartResponse> delCart(@RequestParam Long bufcartID,Authentication auth) throws CartCustomException {
        return clientService.delCart(bufcartID,auth);
    }

    @GetMapping("/placeOrder")
    public ResponseEntity<ServerResponse> placeOrder(Authentication auth) throws PlaceOrderCustomException, ClientNotFoundException {

        return clientService.placeOrder(auth);
    }


}
