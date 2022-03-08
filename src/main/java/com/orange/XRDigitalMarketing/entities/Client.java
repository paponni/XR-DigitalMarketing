package com.orange.XRDigitalMarketing.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
public class Client extends User{

    @OneToMany(mappedBy = "client")
    private List<Tifo> tifos;
    @OneToMany(mappedBy = "client")
    private List<Publicite> publicites;
}
