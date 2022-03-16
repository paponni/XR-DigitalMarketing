package com.orange.XRDigitalMarketing.repos;

import com.orange.XRDigitalMarketing.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepo extends JpaRepository<Ticket,Long> {
//    public int findByNombreTicket(int nombreTicket);
}
