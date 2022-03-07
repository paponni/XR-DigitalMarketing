package com.orange.XRDigitalMarketing.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Tifo extends Affichage{
    private String nomEquipe;
    @ManyToOne
    private Ticket ticket;

}
