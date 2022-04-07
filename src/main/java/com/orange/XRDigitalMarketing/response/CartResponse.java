package com.orange.XRDigitalMarketing.response;

import com.orange.XRDigitalMarketing.entities.Bufcart;
import lombok.Data;

import java.util.List;


@Data
public class CartResponse {
    private String status ;
    private String message;
    private String AUTH_TOKEN;
    private List<Bufcart> bufcartList;
}
