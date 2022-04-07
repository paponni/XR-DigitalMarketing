package com.orange.XRDigitalMarketing.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Entity
@Data
public class PlaceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderID ;
    private String email ;
    private String orderStatus ;
    private Date orderDate ;
    private double costTotal ;

}
