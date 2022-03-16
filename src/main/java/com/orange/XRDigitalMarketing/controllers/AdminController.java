package com.orange.XRDigitalMarketing.controllers;


import com.orange.XRDigitalMarketing.entities.Client;
import com.orange.XRDigitalMarketing.entities.Ticket;
import com.orange.XRDigitalMarketing.exceptions.TicketDuplicatedException;
import com.orange.XRDigitalMarketing.exceptions.TicketNotFoundException;
import com.orange.XRDigitalMarketing.services.IAdminService;
import com.orange.XRDigitalMarketing.services.IClientService;
import com.orange.XRDigitalMarketing.services.ITicketService;
import com.orange.XRDigitalMarketing.utils.Login;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/admin")
@RestController
public class AdminController {


    private final IAdminService adminService;
    private final ITicketService ticketService;
    private final IClientService clientService;

    public AdminController(IAdminService adminService, ITicketService ticketService, IClientService clientService) {
        this.adminService = adminService;
        this.ticketService = ticketService;
        this.clientService = clientService;
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
    ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) throws TicketDuplicatedException {
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
}
