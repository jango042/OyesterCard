package com.alef.education.oyistercardsystem.service;

import com.alef.education.oyistercardsystem.model.StationAndZones;
import com.alef.education.oyistercardsystem.util.FareConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.alef.education.oyistercardsystem.util.FareConstants.OYSTER_CARD_BALANCE;

@Service
@Slf4j
public class JourneyService {

    @Autowired
    private List<StationAndZones> stationAndZonesList;

    private BigDecimal totalJourney = OYSTER_CARD_BALANCE;

    public void calculateJourney (String fromStation, String toStation) {
        int destinationZoneSize = 0;
        int fromZoneSize = 0;
        List<Integer> destinationZonesNum = new ArrayList<>();
        List<Integer> fromZonesNum = new ArrayList<>();
        stationAndZonesList.forEach(stationAndZones -> {
            System.out.println("================="+stationAndZones);

        });


        for (StationAndZones st : stationAndZonesList) {
            if (st.getStationZone().get(toStation) != null || st.getStationZone().get(fromStation) != null) {
                if (st.getStationZone().containsKey(toStation)) {
                    System.out.println("======To size====="+st.getStationZone().get(toStation));
                    destinationZoneSize = st.getStationZone().get(toStation).size();
                    destinationZonesNum = st.getStationZone().get(toStation);
                }
                if (st.getStationZone().containsKey(fromStation)) {
                    System.out.println("======From size====="+st.getStationZone().get(fromStation));
                    fromZoneSize = st.getStationZone().get(fromStation).size();
                    fromZonesNum = st.getStationZone().get(fromStation);
                    //
                }

            }

        }

        //Anywhere in Zone 1
        if (destinationZonesNum.contains(1) && fromZonesNum.contains(1)) {
            System.out.println("Anywhere in Zone 1 ");
        }
        //Any one zone outside zone 1
        if (!destinationZonesNum.contains(1) && !fromZonesNum.contains(1) ) {
            System.out.println("Any one zone outside zone 1");
        }
        //Any two zones including zone 1
        if (destinationZonesNum.contains(2) || destinationZonesNum.contains(3) && destinationZonesNum.contains(1)) {
            System.out.println("Any two zones including zone 1");
        }
        System.out.println("====To======"+destinationZoneSize);
        System.out.println("=====From====="+fromZoneSize);

        System.out.println("====To value======"+destinationZonesNum);
        System.out.println("=====From Value====="+fromZonesNum);

    }

    //        BigDecimal balance = stationAndZonesList.stream().map(stationAndZones -> {
//            List<Integer> fromZones = stationAndZones.getStationZone().get(fromStation);
//            List<Integer> toZones = stationAndZones.getStationZone().get(fromStation);
//
//            //Anywhere in Zone 1
//            if (fromZones.size() == 1 && toZones.size() == 1) {
//
//            }
//            //Any one zone outside zone 1
//            if (fromZones.size() > 1 && toZones.size() > 2) {
//
//            }
//            //Any two zones including zone 1
//            if (fromZones.size() > 1 && toZones.size() > 1) {
//
//            }
//        }).
}
