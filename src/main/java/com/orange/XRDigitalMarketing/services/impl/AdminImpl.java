package com.orange.XRDigitalMarketing.services.impl;

import com.orange.XRDigitalMarketing.entities.Admin;
import com.orange.XRDigitalMarketing.repos.AdminRepo;
import com.orange.XRDigitalMarketing.services.IAdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminImpl implements IAdminService {


    private final AdminRepo adminRepo;

    public AdminImpl(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    @Override
    public ResponseEntity<?> login(Admin admin) {
        Admin ad = adminRepo.findByEmailAndPassword(admin.getEmail(),admin.getPassword());
        if(ad!=null)
            return ResponseEntity.status(HttpStatus.OK)
                    .body(ad);
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("invalid credentials");

    }
}
