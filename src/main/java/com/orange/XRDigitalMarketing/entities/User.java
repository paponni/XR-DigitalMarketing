package com.orange.XRDigitalMarketing.entities;


import com.orange.XRDigitalMarketing.enumeration.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Inheritance(strategy=InheritanceType.JOINED)
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
    private Boolean enabled = false;
    @Enumerated(EnumType.STRING)
    private  UserRole userRole;

    public User(String nom, String prenom, String email, String password, UserRole userRole) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    public User(Long id, String nom, String prenom, String email, String password, String adresse, String tel, String ville, UserRole userRole) {
    }
}
