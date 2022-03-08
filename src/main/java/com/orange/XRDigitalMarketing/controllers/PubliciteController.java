package com.orange.XRDigitalMarketing.controllers;


import com.orange.XRDigitalMarketing.entities.Publicite;
import com.orange.XRDigitalMarketing.exceptions.PubliciteNotValidException;
import com.orange.XRDigitalMarketing.services.IPubliciteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PubliciteController {

    private final IPubliciteService publiciteService ;
    public PubliciteController(IPubliciteService publiciteService) {
        this.publiciteService = publiciteService;
    }


    @PostMapping("/publicite/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Publicite createPublicite(@RequestBody Publicite publicite) throws PubliciteNotValidException {
        return publiciteService.createPublicite(publicite);
    }


    @GetMapping("/publicites")
    @ResponseStatus(HttpStatus.OK)
    public List<Publicite> getAllPublicite(){
        return publiciteService.getAllPublicites();
    }
}
