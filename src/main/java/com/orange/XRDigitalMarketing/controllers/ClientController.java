package com.orange.XRDigitalMarketing.controllers;


import com.orange.XRDigitalMarketing.entities.Client;
import com.orange.XRDigitalMarketing.services.IClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
public class ClientController {
    private final IClientService clientService;

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody Client client){
        return clientService.login(client);
    }
}
