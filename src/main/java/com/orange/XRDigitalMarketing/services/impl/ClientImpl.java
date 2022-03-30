package com.orange.XRDigitalMarketing.services.impl;


import com.orange.XRDigitalMarketing.entities.Client;
import com.orange.XRDigitalMarketing.entities.ConfirmationToken;
import com.orange.XRDigitalMarketing.entities.Ticket;
import com.orange.XRDigitalMarketing.repos.ClientRepo;
import com.orange.XRDigitalMarketing.repos.TicketRepo;
import com.orange.XRDigitalMarketing.services.ConfirmationTokenService;
import com.orange.XRDigitalMarketing.services.IClientService;
import com.orange.XRDigitalMarketing.utils.Login;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@Transactional
public class ClientImpl implements IClientService {


    private final ClientRepo clientRepo;
    private final ConfirmationTokenService confirmationTokenService;
    private final TicketRepo ticketRepo;
    private final PasswordEncoder passwordEncoder;


    public ClientImpl(ClientRepo clientRepo, ConfirmationTokenService confirmationTokenService, TicketRepo ticketRepo, PasswordEncoder passwordEncoder) {
        this.clientRepo = clientRepo;
        this.confirmationTokenService = confirmationTokenService;
        this.ticketRepo = ticketRepo;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public ResponseEntity<?> login(Login login) {
        log.info("login client by email : {} ",login.getEmail());
        Client cl = clientRepo.findByEmailAndPassword(login.getEmail(), login.getPassword());
        if (cl != null)
            return ResponseEntity.status(HttpStatus.OK)
                    .body(cl);
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("invalid client credential");
    }

    @Override
    public String register(Client client) throws Exception {
        log.info("register client id :{}",client.getId());
        System.out.println(client.getEmail());
        if(clientRepo.findByEmail(client.getEmail()).isPresent()){
            throw new Exception("This email already exists try another one");
        }
        if(clientRepo.findByTel(client.getTel()).isPresent()){
            throw new Exception("This Tel already exists try another one");
        }
        String password = client.getPassword();
        System.out.println(password);
        if(!password.isEmpty() && password.length() >= 8){
            client.setPassword(passwordEncoder.encode(password));
        }
        else{
            throw new Exception("password does not setted");
        }
        clientRepo.save(client);
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken
                (token, LocalDateTime.now(),LocalDateTime.now().plusMinutes(15),client);
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token ;
    }

    @Override
    public List<Client> getClients() {
        return clientRepo.findAll();
    }

    @Override
    public int enableAppUser(String email) {
        return clientRepo.enableAppUser(email);
    }

    @Override
    public Ticket acheterTicket(Long id,int nbrTicketAchete, Ticket ticket) throws Exception {
        log.info("l achat du ticket by client with id {}",id);
        Client client = clientRepo.findById(id).orElse(null);
        if(client == null)
            throw new Exception("client not found with id :"+id);

        List<Ticket> tickets= client.getTickets();
        if(ticket.getNombreTicket() - nbrTicketAchete <= 0)
            throw new Exception("Tickets arent dispo");

        int nbrTicketreste = ticket.getNombreTicket() - nbrTicketAchete;
        ticket.setNombreTicket(nbrTicketreste);
        ticketRepo.save(ticket);
        tickets.add(ticket);
        client.setTickets(tickets);
        clientRepo.save(client);

        return ticketRepo.save(ticket);
    }


    private String buildEmail(String name, String link) {
        return "<div style=\"font-family:Helvetica,Arial,sans-serif;font-size:16px;margin:0;color:#0b0c0c\">\n" +
                "\n" +
                "<span style=\"display:none;font-size:1px;color:#fff;max-height:0\"></span>\n" +
                "\n" +
                "  <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;min-width:100%;width:100%!important\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"100%\" height=\"53\" bgcolor=\"#0b0c0c\">\n" +
                "        \n" +
                "        <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;max-width:580px\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\n" +
                "          <tbody><tr>\n" +
                "            <td width=\"70\" bgcolor=\"#0b0c0c\" valign=\"middle\">\n" +
                "                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td style=\"padding-left:10px\">\n" +
                "                  \n" +
                "                    </td>\n" +
                "                    <td style=\"font-size:28px;line-height:1.315789474;Margin-top:4px;padding-left:10px\">\n" +
                "                      <span style=\"font-family:Helvetica,Arial,sans-serif;font-weight:700;color:#ffffff;text-decoration:none;vertical-align:top;display:inline-block\">Confirm your email</span>\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "              </a>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"10\" height=\"10\" valign=\"middle\"></td>\n" +
                "      <td>\n" +
                "        \n" +
                "                <table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td bgcolor=\"#1D70B8\" width=\"100%\" height=\"10\"></td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\" height=\"10\"></td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "\n" +
                "\n" +
                "\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "      <td style=\"font-family:Helvetica,Arial,sans-serif;font-size:19px;line-height:1.315789474;max-width:560px\">\n" +
                "        \n" +
                "            <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">Hi " + name + ",</p><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> Thank you for registering. Please click on the below link to activate your account: </p><blockquote style=\"Margin:0 0 20px 0;border-left:10px solid #b1b4b6;padding:15px 0 0.1px 15px;font-size:19px;line-height:25px\"><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> <a href=\"" + link + "\">Activate Now</a> </p></blockquote>\n Link will expire in 15 minutes. <p>See you soon</p>" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "  </tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n" +
                "\n" +
                "</div></div>";
    }




}

