package com.orange.XRDigitalMarketing.entities;


import com.orange.XRDigitalMarketing.enumeration.ZoneTicket;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Bufcart  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bufcartID ;
    private Long orderID;
    private String email;
    private Date dateAdded ;
    private Long ticketID;
    private String ticketName ;
    private int zoneTicket;
    private double price;
    private int quantite;

}
