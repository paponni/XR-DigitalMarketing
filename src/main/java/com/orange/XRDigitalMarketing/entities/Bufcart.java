package com.orange.XRDigitalMarketing.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private double price;
    private int quantite;

}
