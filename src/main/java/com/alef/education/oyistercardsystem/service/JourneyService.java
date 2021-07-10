package com.alef.education.oyistercardsystem.service;

import com.alef.education.oyistercardsystem.enums.StationAndZoneEnum;
import com.alef.education.oyistercardsystem.enums.TransportEnum;
import com.alef.education.oyistercardsystem.model.Account;
import com.alef.education.oyistercardsystem.model.TransportJourney;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import static com.alef.education.oyistercardsystem.util.FareConstants.OYSTER_CARD_BALANCE;

@Service
@Slf4j
public class JourneyService {

    public void calculateJourney(){
        try {
            Account account = new Account();

            account.addMoney(OYSTER_CARD_BALANCE);

            TransportJourney jorneyHolbornToCourt = new TransportJourney();
            jorneyHolbornToCourt.setStartPoint(TransportEnum.TUBE,StationAndZoneEnum.HOLBORN,account);
            jorneyHolbornToCourt.setEndPoint(StationAndZoneEnum.EARLS_COURT);

            log.info("Card Balance after first journey (Tube Holborn to Earl’s Court)  is : %s \n",account.getAccountBalance());

            TransportJourney jorneyBusEarlToChelsea = new TransportJourney();
            jorneyBusEarlToChelsea.setStartPoint(TransportEnum.BUS,null,account);
            jorneyBusEarlToChelsea.setEndPoint(null);

            log.info("Card Balance after second journey (328 bus from Earl’s Court to Chelsea) is : %s \n",account.getAccountBalance());

            TransportJourney jorneyEarlsToHammersmith = new TransportJourney();
            jorneyEarlsToHammersmith.setStartPoint(TransportEnum.TUBE, StationAndZoneEnum.EARLS_COURT, account);
            jorneyEarlsToHammersmith.setEndPoint(StationAndZoneEnum.HAMMERSMITH);

            log.info("Card Balance after third journey (Tube Earl’s court to Hammersmith)  is : %s \n",account.getAccountBalance());
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }


}

