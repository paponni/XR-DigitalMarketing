package com.orange.XRDigitalMarketing.controllers;


import com.orange.XRDigitalMarketing.services.IClientService;
import com.orange.XRDigitalMarketing.services.RegistrationService;
import com.orange.XRDigitalMarketing.utils.Login;
import com.orange.XRDigitalMarketing.utils.RegistrationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/client")
@RestController
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


}
