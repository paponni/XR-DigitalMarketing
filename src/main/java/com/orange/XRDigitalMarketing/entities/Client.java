package com.orange.XRDigitalMarketing.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.orange.XRDigitalMarketing.enumeration.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data @NoArgsConstructor
public class Client extends User{

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Tifo> tifos;
    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Publicite> publicites;
    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Ticket> tickets;


    public Client
            (Long id, String nom, String prenom, String email, String password, String adresse, String tel, String ville, UserRole userRole, List<Tifo> tifos, List<Publicite> publicites, List<Ticket> tickets) {
        super(id, nom, prenom, email, password, adresse, tel, ville, userRole);
        this.tifos = tifos;
        this.publicites = publicites;
        this.tickets = tickets;
    }

    public Client(String nom, String prenom, String email, String password, UserRole userRole) {
        super(nom, prenom, email, password, userRole);
    }

    public Client(List<Tifo> tifos, List<Publicite> publicites, List<Ticket> tickets) {
        this.tifos = tifos;
        this.publicites = publicites;
        this.tickets = tickets;
    }
}
