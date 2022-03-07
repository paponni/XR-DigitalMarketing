package com.orange.XRDigitalMarketing.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nom ;
    private String prenom ;
    private String email ;
    private String password ;
    private String adresse;
    private String tel ;
    private String ville ;
    private LocalDate dateNaissance ;
    @OneToOne
    private Compte compte;
    @OneToOne
    private Role role ;

}
