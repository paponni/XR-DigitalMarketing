package com.orange.XRDigitalMarketing.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {
    @Id
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
    @ManyToOne
    private Role role ;

}
