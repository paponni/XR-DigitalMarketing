package com.orange.XRDigitalMarketing.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private List<Ticket> tickets;
    @OneToMany(mappedBy = "admin")
    @JsonIgnore
    private List<Tifo> tifos;
    @OneToMany(mappedBy = "admin")
    @JsonIgnore
    private List<Publicite> publicites;

}
