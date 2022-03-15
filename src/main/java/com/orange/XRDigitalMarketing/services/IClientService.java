package com.orange.XRDigitalMarketing.services;

import com.orange.XRDigitalMarketing.entities.Client;
import com.orange.XRDigitalMarketing.utils.Login;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IClientService {
    public ResponseEntity<?> login(Login login);

    public String register(Client client) throws Exception;

    List<Client> getClients();

    int enableAppUser(String email);
}
