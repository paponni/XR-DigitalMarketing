package com.orange.XRDigitalMarketing.services;

import com.orange.XRDigitalMarketing.entities.Ticket;
import com.orange.XRDigitalMarketing.exceptions.TicketDuplicatedException;
import com.orange.XRDigitalMarketing.exceptions.TicketNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITicketService {
    List<Ticket> loadAllTickets();

    ResponseEntity<Ticket> loadTicket(Long id);

    ResponseEntity<Ticket> createTicket(Ticket ticket) throws TicketDuplicatedException;

    ResponseEntity<Ticket> updateTicket(Ticket ticket) throws TicketNotFoundException;

    Long removeTicket(Long id) throws TicketNotFoundException;

    Ticket getTicket(Long id);
}
