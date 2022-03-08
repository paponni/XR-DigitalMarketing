package com.orange.XRDigitalMarketing.entities;

import com.orange.XRDigitalMarketing.enumeration.StatusTicket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nomMatch ;
    private LocalDate dateMatch ;
    private LocalTime heureMatch ;
    private String lieuMatch ;
    private BigDecimal prix ;
    private String photo ;
    private int nombreTicket;
    private StatusTicket statusTicket;
    @OneToMany
    private List<Tifo> tifos;
    @ManyToOne
    private Admin admin;
}

