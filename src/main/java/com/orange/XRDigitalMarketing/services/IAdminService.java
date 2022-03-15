package com.orange.XRDigitalMarketing.services;


import com.orange.XRDigitalMarketing.utils.Login;
import org.springframework.http.ResponseEntity;

public interface IAdminService {
    public ResponseEntity<?> login(Login login);
}
