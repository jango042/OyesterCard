package com.alef.education.oyistercardsystem;

import com.alef.education.oyistercardsystem.service.JourneyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
@Slf4j
public class OystercardsystemApplication {



	public static void main(String[] args) {
		SpringApplication.run(OystercardsystemApplication.class, args);

//		ApplicationContext applicationContext = SpringApplication.run(OystercardsystemApplication.class, args);
//		JourneyService service = applicationContext.getBean(JourneyService.class);
//		service.calculateJourney();

		JourneyService userLoginRepo = (JourneyService) SpringApplicationContext.getBean("journeyService");
		userLoginRepo.calculateJourney();
	}


}
