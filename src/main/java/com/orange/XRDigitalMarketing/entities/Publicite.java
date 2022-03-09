package com.orange.XRDigitalMarketing.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor

public class Publicite extends Pixel{
    private String nomPub ;
    @ManyToOne(fetch = FetchType.LAZY)
    private Ticket ticket;
    @ManyToOne(fetch = FetchType.LAZY)
    private Admin admin;
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    public Publicite(Long id, LocalDate dateAffichage, LocalTime heureAffichge
            , double dureeAffichage, String photo, String nomPub, Ticket ticket, Admin admin, Client client) {
        super(id, dateAffichage, heureAffichge, dureeAffichage, photo);
        this.nomPub = nomPub;
        this.ticket = ticket;
        this.admin = admin;
        this.client = client;
    }
}
