package com.alef.education.oyistercardsystem.controller;

import com.alef.education.oyistercardsystem.service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oyster/card")
public class OysterCardController {

    @Autowired
    private JourneyService journeyService;

    @GetMapping
    public ResponseEntity<?> print() {
        journeyService.calculateJourney("Wimbledon", "Earl’s Court");
        return ResponseEntity.ok("Success");
    }
}
