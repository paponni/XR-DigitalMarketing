package com.orange.XRDigitalMarketing.services.impl;

import com.orange.XRDigitalMarketing.entities.Ticket;
import com.orange.XRDigitalMarketing.exceptions.TicketDuplicatedException;
import com.orange.XRDigitalMarketing.exceptions.TicketNotFoundException;
import com.orange.XRDigitalMarketing.repos.TicketRepo;
import com.orange.XRDigitalMarketing.services.ITicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Slf4j
@Transactional
public class TicketService implements ITicketService {

    private final TicketRepo ticketRepo;

    public TicketService(TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }


    @Override
    public List<Ticket> loadAllTickets() {
        log.info("fetch all tickets");
        return ticketRepo.findAll();
    }

    @Override
    public ResponseEntity<Ticket> loadTicket(Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ticketRepo.findById(id).get());
    }

    @Override
    public ResponseEntity<Ticket> createTicket(Ticket ticket) throws TicketDuplicatedException {
        log.info("save ticket {}",ticket.getNomMatch());
        Ticket ticketFromDB = ticketRepo.findById(ticket.getId()).orElse(null);
        if( ticketFromDB != null)
            throw new TicketDuplicatedException(ticket.getId());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ticketRepo.save(ticket));
    }

    @Override
    public ResponseEntity<Ticket> updateTicket(Ticket ticket) throws TicketNotFoundException {
        log.info("update ticket {}",ticket.getId());
        Ticket ticketFromDB = ticketRepo.findById(ticket.getId()).orElse(null);
        if(ticketFromDB == null)
            throw new TicketNotFoundException(ticket.getId());
        ticket.setId(ticketFromDB.getId());

        return ResponseEntity.status(HttpStatus.OK)
                .body(ticketRepo.save(ticket));
    }

    @Override
    public Long removeTicket(Long id) throws TicketNotFoundException {
        log.info("delete ticket by id : {}",id);
        Ticket ticketFromDB = ticketRepo.findById(id).orElse(null);
        if(ticketFromDB == null)
            throw new TicketNotFoundException(id);
        ticketRepo.delete(ticketFromDB);
        return id;

    }

}
