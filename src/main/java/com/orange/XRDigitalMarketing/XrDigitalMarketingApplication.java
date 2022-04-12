package com.orange.XRDigitalMarketing;

import com.orange.XRDigitalMarketing.entities.Admin;
import com.orange.XRDigitalMarketing.entities.Client;
import com.orange.XRDigitalMarketing.entities.Ticket;
import com.orange.XRDigitalMarketing.enumeration.StatusTicket;
import com.orange.XRDigitalMarketing.enumeration.UserRole;
import com.orange.XRDigitalMarketing.repos.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
	@Autowired
	private AdminRepo adminRepo;

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
		Client cl = new Client("spooky","boi","spooky@example.com",passwordEncoder().encode("1234"),UserRole.USER);
		Admin admin = new Admin(null,"admin","admin","admin@example.com",passwordEncoder().encode("1234"),null,null,null,true,UserRole.ADMIN);
		clientRepo.save(cl);
		adminRepo.save(admin);
		Ticket ticket = new Ticket(null,"Atletico madrid vs Valencia CF", LocalDate.now(), LocalTime.now(),"Estadio el madrigal ,villarreal ,Spain ",100,"christian-pulisic-chelsea.jpg",200, StatusTicket.en_cours,null,null,null);
		Ticket ticket1 = new Ticket(null,"Real madrid vs FC Barcelone", LocalDate.now(), LocalTime.now(),"Estadio el madrigal ,villarreal ,Spain 	",200,"christian-pulisic-chelsea.jpg",200, StatusTicket.en_cours,null,null,null);
		Ticket ticket3 = new Ticket(null,"Chilsea vs FC Liverpool", LocalDate.now(), LocalTime.now(),"Estadio el madrigal ,villarreal ,Spain 	",400,"christian-pulisic-chelsea.jpg",200, StatusTicket.en_cours,null,null,null);

		ticketRepo.save(ticket);
		ticketRepo.save(ticket1);
		ticketRepo.save(ticket3);
	}


	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
