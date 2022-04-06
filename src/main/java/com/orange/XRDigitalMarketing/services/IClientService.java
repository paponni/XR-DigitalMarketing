package com.orange.XRDigitalMarketing.services;

import com.orange.XRDigitalMarketing.entities.Client;
import com.orange.XRDigitalMarketing.entities.Ticket;
import com.orange.XRDigitalMarketing.exceptions.ClientNotFoundException;
import com.orange.XRDigitalMarketing.utils.Login;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IClientService {
    public ResponseEntity<?> login(Login login);

    public String register(Client client) throws Exception;

    List<Client> getClients();

    int enableAppUser(String email);
    Ticket acheterTicket(Long id,int nbrTicketAchete,Ticket ticket) throws Exception;

    Client getClient(String email) throws ClientNotFoundException;
}
