package com.orange.XRDigitalMarketing.services.impl;

import com.orange.XRDigitalMarketing.entities.Ticket;
import com.orange.XRDigitalMarketing.enumeration.StatusTicket;
import com.orange.XRDigitalMarketing.exceptions.TicketDuplicatedException;
import com.orange.XRDigitalMarketing.exceptions.TicketNotFoundException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketServiceTest {

    @Autowired
    private TicketService  ticketService;

    @Test
    public void shouldSaveTicketWithSuccess() throws TicketDuplicatedException {
        Ticket expectedTicket = Ticket.builder()
                .id(3L)
                .nomMatch("FC BARCELONE VS REAL MADRID")
                .dateMatch(LocalDate.parse("2022-03-22"))
                .heureMatch(LocalTime.parse("18:37:06.743456"))
                .lieuMatch("BERNABIO")
                .nombreTicket(3000)
                .photo("test.png")
                .prix(new BigDecimal(5000))
                .statusTicket(StatusTicket.en_cours)
                .build();
        ResponseEntity<Ticket> savedTicket = ticketService.createTicket(expectedTicket);
        assertNotNull(savedTicket);
        assertNotNull(savedTicket.getBody().getId());
        Assertions.assertEquals(expectedTicket.getNomMatch(),savedTicket.getBody().getNomMatch());
        Assertions.assertEquals(expectedTicket.getLieuMatch(),savedTicket.getBody().getLieuMatch());
        Assertions.assertEquals(expectedTicket.getStatusTicket(),savedTicket.getBody().getStatusTicket());
        Assertions.assertEquals(expectedTicket.getHeureMatch(),savedTicket.getBody().getHeureMatch());

    }
    @Test
    public void shouldUpdateTicketWithSuccess() throws TicketDuplicatedException, TicketNotFoundException {
        Ticket expectedTicket = Ticket.builder()
                .id(3L)
                .nomMatch("FC BARCELONE VS REAL MADRID")
                .dateMatch(LocalDate.parse("2022-03-22"))
                .heureMatch(LocalTime.parse("18:37:06.743456"))
                .lieuMatch("BERNABIO")
                .nombreTicket(3000)
                .photo("test.png")
                .prix(new BigDecimal(5000))
                .statusTicket(StatusTicket.en_cours)
                .build();


        ResponseEntity<Ticket> savedTicket = ticketService.createTicket(expectedTicket);

        Ticket ticketToUpdate = savedTicket.getBody();
        ticketToUpdate.setNombreTicket(3001);

        savedTicket = ticketService.updateTicket(ticketToUpdate);


        assertNotNull(ticketToUpdate);
        assertNotNull(ticketToUpdate.getId());
        Assertions.assertEquals(ticketToUpdate.getNomMatch(),savedTicket.getBody().getNomMatch());
        Assertions.assertEquals(ticketToUpdate.getLieuMatch(),savedTicket.getBody().getLieuMatch());
        Assertions.assertEquals(ticketToUpdate.getStatusTicket(),savedTicket.getBody().getStatusTicket());
        Assertions.assertEquals(ticketToUpdate.getHeureMatch(),savedTicket.getBody().getHeureMatch());
        Assertions.assertEquals(ticketToUpdate.getNombreTicket(),savedTicket.getBody().getNombreTicket());

    }

}