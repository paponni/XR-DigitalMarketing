package com.orange.XRDigitalMarketing.services;

import com.orange.XRDigitalMarketing.entities.Client;
import org.springframework.http.ResponseEntity;

public interface IClientService {
    public ResponseEntity<?> login(Client client);
}
