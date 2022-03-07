package com.orange.XRDigitalMarketing.entities;

import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Publicite extends Affichage{
    private String nomPub ;
    @ManyToMany(mappedBy = "publicite")
    private List<Ticket> tickets;
}
