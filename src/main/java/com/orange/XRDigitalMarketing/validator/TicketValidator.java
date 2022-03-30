package com.orange.XRDigitalMarketing.validator;

import com.orange.XRDigitalMarketing.entities.Ticket;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TicketValidator {


    public List<String> validate(Ticket ticket){
        List<String> errors = new ArrayList<>();
        if(!StringUtils.hasLength(ticket.getNomMatch())){
            errors.add("veuillez renseigner le nom du match");
        }
        if(!StringUtils.hasLength(String.valueOf(ticket.getPrix()))){
            errors.add("veuillez renseigner le prix du match");
        }
        if(!StringUtils.hasLength(String.valueOf(ticket.getPrix()))){
            errors.add("veuillez renseigner le prix du match");
        }
        if(!StringUtils.hasLength(String.valueOf(ticket.getPrix()))){
            errors.add("veuillez renseigner le prix du match");
        }
        return errors;

}}
