package com.orange.XRDigitalMarketing.services;


import com.orange.XRDigitalMarketing.entities.Admin;
import org.springframework.http.ResponseEntity;

public interface IAdminService {
    public ResponseEntity<?> login(Admin admin);
}
