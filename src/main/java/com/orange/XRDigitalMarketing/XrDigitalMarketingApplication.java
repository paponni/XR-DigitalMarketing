package com.orange.XRDigitalMarketing;

import com.orange.XRDigitalMarketing.entities.Tifo;
import com.orange.XRDigitalMarketing.repos.TifoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class XrDigitalMarketingApplication implements CommandLineRunner {

	@Autowired
	private TifoRepo tifoRepo;
	public static void main(String[] args) {
		SpringApplication.run(XrDigitalMarketingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	Tifo tifo = new Tifo(null,LocalDate.now(),LocalTime.now(),2,"test.png","kokab",null,null,null);
	Tifo tifo2 = new Tifo(null,LocalDate.now(),LocalTime.now(),2,"hhh.png","equipe maroc",null,null,null);
	tifoRepo.save(tifo);
	tifoRepo.save(tifo2);
	}

}
