package com.orange.XRDigitalMarketing.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Tifo extends Pixel{
    private String nomEquipe;
    @ManyToOne(cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    private Ticket ticket;
    @ManyToOne(cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    private Admin admin;
    @ManyToOne(cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    private Client client;

    public Tifo(Long id, LocalDate dateAffichage, LocalTime heureAffichge, double dureeAffichage, String photo
            , String nomEquipe, Ticket ticket, Admin admin, Client client) {
        super(id, dateAffichage, heureAffichge, dureeAffichage, photo);
        this.nomEquipe = nomEquipe;
        this.ticket = ticket;
        this.admin = admin;
        this.client = client;
    }
}
