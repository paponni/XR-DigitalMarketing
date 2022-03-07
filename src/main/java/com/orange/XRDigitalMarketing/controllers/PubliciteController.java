package com.orange.XRDigitalMarketing.controllers;


import com.orange.XRDigitalMarketing.entities.Publicite;
import com.orange.XRDigitalMarketing.services.IPubliciteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class PubliciteController {

    private final IPubliciteService publiciteService ;


    public PubliciteController(IPubliciteService publiciteService) {
        this.publiciteService = publiciteService;
    }

    @PostMapping("/publicite")
    public Publicite uploadPublcite(Publicite publicite){
        return publiciteService.uploadPublicite(publicite);
    }

}
