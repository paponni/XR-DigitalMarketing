package com.orange.XRDigitalMarketing.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Admin extends User{


    @OneToMany(mappedBy = "admin")
    private List<Ticket> tickets;
    @OneToMany(mappedBy = "admin")
    private List<Tifo> tifos;
    @OneToMany(mappedBy = "admin")
    private List<Publicite> publicites;

}
