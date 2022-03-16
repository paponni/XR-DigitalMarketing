package com.orange.XRDigitalMarketing;

import com.orange.XRDigitalMarketing.entities.Client;
import com.orange.XRDigitalMarketing.entities.Ticket;
import com.orange.XRDigitalMarketing.enumeration.StatusTicket;
import com.orange.XRDigitalMarketing.enumeration.UserRole;
import com.orange.XRDigitalMarketing.repos.PubliciteRepo;
import com.orange.XRDigitalMarketing.repos.TicketRepo;
import com.orange.XRDigitalMarketing.repos.TifoRepo;
import com.orange.XRDigitalMarketing.repos.ClientRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class XrDigitalMarketingApplication implements CommandLineRunner {

	@Autowired
	private TifoRepo tifoRepo;
	@Autowired
	private PubliciteRepo publiciteRepo;
	@Autowired
	private ClientRepo clientRepo;
	@Autowired
	private TicketRepo ticketRepo;
	public static void main(String[] args) {
		SpringApplication.run(XrDigitalMarketingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//	Tifo tifo = new Tifo(null,LocalDate.now(),LocalTime.now(),2,"test.png","kokab",null,null,null);
//	Tifo tifo2 = new Tifo(null,LocalDate.now(),LocalTime.now(),2,"hhh.png","equipe maroc",null,null,null);
//	tifoRepo.save(tifo);
//	tifoRepo.save(tifo2);
//		Publicite publicite = new Publicite
//				(null,LocalDate.now(),LocalTime.now(),4
//						,"photo.jpeg","Genova",null,null,null);
//		publiciteRepo.save(publicite);

//		Client client= new Client(null,"Mamoun","Mohamed","mohamed@example.com","123456","marrakech","0661626364","Marrakech", UserRole.USER,null,null,null);
//		clientRepo.save(client);
		Ticket ticket = new Ticket(null,"KACM vs RCA", LocalDate.now(), LocalTime.now(),"Marrakech",new BigDecimal("2000"),"test.png",200, StatusTicket.en_cours,null,null,null);

		ticketRepo.save(ticket);
	}


}
