package com.alef.education.oyistercardsystem;

import com.alef.education.oyistercardsystem.service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner  implements CommandLineRunner {
    @Autowired
    private JourneyService myService;

    @Override
    public void run(String...args) throws Exception {
        myService.calculateJourney();

    }
}
