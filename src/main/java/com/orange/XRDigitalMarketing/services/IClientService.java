package com.orange.XRDigitalMarketing.services;

import com.orange.XRDigitalMarketing.entities.Client;
import com.orange.XRDigitalMarketing.entities.Ticket;
import com.orange.XRDigitalMarketing.exceptions.CartCustomException;
import com.orange.XRDigitalMarketing.exceptions.ClientNotFoundException;
import com.orange.XRDigitalMarketing.exceptions.PlaceOrderCustomException;
import com.orange.XRDigitalMarketing.response.CartResponse;
import com.orange.XRDigitalMarketing.response.ServerResponse;
import com.orange.XRDigitalMarketing.utils.Login;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import java.util.HashMap;
import java.util.List;

public interface IClientService {
    public ResponseEntity<?> login(Login login);

    public String register(Client client) throws Exception;

    List<Client> getClients();

    int enableAppUser(String email);
    Ticket acheterTicket(Long id,int nbrTicketAchete,Ticket ticket) throws Exception;

    Client getClient(String email) throws ClientNotFoundException;

    ResponseEntity<ServerResponse> addToCart(Long ticketID, Authentication authentication) throws ClientNotFoundException, CartCustomException;

    ResponseEntity<CartResponse> viewCart(Authentication authentication) throws CartCustomException;

    ResponseEntity<CartResponse> updateCart(HashMap<String, String> cart, Authentication auth) throws CartCustomException;

    ResponseEntity<CartResponse> delCart(Long bufcartID, Authentication auth) throws CartCustomException;

    ResponseEntity<ServerResponse> placeOrder(Authentication auth) throws ClientNotFoundException, PlaceOrderCustomException;
}
