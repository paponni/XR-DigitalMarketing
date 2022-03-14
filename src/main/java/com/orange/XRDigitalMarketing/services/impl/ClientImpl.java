package com.orange.XRDigitalMarketing.services.impl;


import com.orange.XRDigitalMarketing.entities.Client;
import com.orange.XRDigitalMarketing.repos.ClientRepo;
import com.orange.XRDigitalMarketing.services.IClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientImpl implements IClientService {


    private final ClientRepo clientRepo;

    public ClientImpl(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }


    @Override
    public ResponseEntity<?> login(Client client) {
        Client cl = clientRepo.findByEmailAndPassword(client.getEmail(), client.getPassword());
        if (cl != null)
            return ResponseEntity.status(HttpStatus.OK)
                    .body(cl);
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("invalid client credential");
    }
}
