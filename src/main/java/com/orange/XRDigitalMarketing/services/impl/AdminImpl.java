package com.orange.XRDigitalMarketing.services.impl;

import com.orange.XRDigitalMarketing.entities.Admin;
import com.orange.XRDigitalMarketing.repos.AdminRepo;
import com.orange.XRDigitalMarketing.services.IAdminService;
import com.orange.XRDigitalMarketing.utils.Login;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdminImpl implements IAdminService {


    private final AdminRepo adminRepo;

    public AdminImpl(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    @Override
    public ResponseEntity<?> login(Login login) {
        Admin ad = adminRepo.findByEmailAndPassword(login.getEmail(),login.getPassword());
        if(ad!=null)
            return ResponseEntity.status(HttpStatus.OK)
                    .body(ad);
        else
            log.error("admin with email {} not valid",login.getEmail());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("invalid admin credentials");

    }
}
