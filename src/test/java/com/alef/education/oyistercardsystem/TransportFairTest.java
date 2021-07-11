package com.alef.education.oyistercardsystem;

import com.alef.education.oyistercardsystem.enums.StationAndZoneEnum;
import com.alef.education.oyistercardsystem.enums.TransportEnum;
import com.alef.education.oyistercardsystem.model.Account;
import com.alef.education.oyistercardsystem.model.TransportFare;
import com.alef.education.oyistercardsystem.model.TransportJourney;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TransportFairTest {

    @Test(expected = Exception.class)
    public void testValidadeBusException() {

        Account account = new Account(TransportFare.ANY_BUS_ROUTE.subtract(new BigDecimal(1)));
        TransportFare fare = new TransportFare();
        fare.validade(TransportEnum.BUS, account);
    }

    @Test(expected = Exception.class)
    public void testValidadeTubeFareException() {

        Account account = new Account(TransportFare.BASIC_TUBE_FARE.subtract(new BigDecimal(1)));
        TransportFare fare = new TransportFare();
        fare.validade(TransportEnum.TUBE, account);
    }

    @Test
    public void testChargeMaxTube() {
        Account account = new Account(TransportFare.BASIC_TUBE_FARE);
        TransportFare fare = new TransportFare();
        fare.chargeMax(TransportEnum.TUBE, account);
       assertEquals(String.valueOf(new BigDecimal(0)), account.getAccountBalance(), new BigDecimal("0.0"));
    }

    @Test
    public void testChargeMaxBus() {
        Account account = new Account(TransportFare.ANY_BUS_ROUTE);
        TransportFare fare = new TransportFare();
        fare.chargeMax(TransportEnum.BUS, account);
        assertEquals(String.valueOf(new BigDecimal(0)), account.getAccountBalance(), new BigDecimal("0.0"));
    }

    @Test
    public void testChargeBus() {
        Account account = new Account(TransportFare.ANY_BUS_ROUTE);
        TransportFare fare = new TransportFare();
        TransportJourney jorneyBusEarlToChelsea = new TransportJourney();
        jorneyBusEarlToChelsea.setStartPoint(TransportEnum.BUS, null, account);
        jorneyBusEarlToChelsea.setEndPoint(null);
        fare.charge(TransportEnum.BUS,jorneyBusEarlToChelsea, account);
        assertEquals(String.valueOf(new BigDecimal(0)), account.getAccountBalance(), new BigDecimal(0.0));
    }

    @Test
    public void testChargeTubZoneOne() {
        Account account = new Account(TransportFare.ANY_BUS_ROUTE);
        TransportFare fare = new TransportFare();
        TransportJourney jorneyBusEarlToChelsea = new TransportJourney();
        jorneyBusEarlToChelsea.setStartPoint(TransportEnum.TUBE, StationAndZoneEnum.EARLS_COURT.HOLBORN, account);
        jorneyBusEarlToChelsea.setEndPoint(StationAndZoneEnum.EARLS_COURT);
        assertEquals(String.valueOf(TransportFare.BASIC_TUBE_FARE.subtract(TransportFare.ANYWHERE_IN_ZONE_1)), account.getAccountBalance(), new BigDecimal(0.0));
    }

    @Test
    public void testChargeTubAnyZoneOutSideZoneOne() {
        Account account = new Account(TransportFare.ANY_BUS_ROUTE);
        TransportFare fare = new TransportFare();
        TransportJourney jorneyBusEarlToChelsea = new TransportJourney();
        jorneyBusEarlToChelsea.setStartPoint(TransportEnum.TUBE, StationAndZoneEnum.HAMMERSMITH, account);
        jorneyBusEarlToChelsea.setEndPoint(StationAndZoneEnum.EARLS_COURT);
        //	assertEquals(Fare.BASIC_TUBE_FARE - Fare.ANY_ZONE_OUTSIDE_ZONE_ONE_FARE, card.getBalance(), 0.001f);
    }

    @Test
    public void testChargeTubTwoInZoneOne() {
        Account account = new Account(TransportFare.ANY_BUS_ROUTE);
        TransportFare fare = new TransportFare();
        TransportJourney jorneyBusEarlToChelsea = new TransportJourney();
        jorneyBusEarlToChelsea.setStartPoint(TransportEnum.TUBE, StationAndZoneEnum.HAMMERSMITH, account);
        jorneyBusEarlToChelsea.setEndPoint(StationAndZoneEnum.HOLBORN);
        assertEquals(String.valueOf(TransportFare.BASIC_TUBE_FARE.subtract(TransportFare.ANY_TWO_ZONES_INCLUDING_ZONE_1)), account.getAccountBalance(), new BigDecimal(0.001));
    }

    @Test
    public void testChargeTubTwoExcZoneOne() {
        Account account = new Account(TransportFare.ANY_BUS_ROUTE);
        TransportFare fare = new TransportFare();
        TransportJourney jorneyBusEarlToChelsea = new TransportJourney();
        jorneyBusEarlToChelsea.setStartPoint(TransportEnum.TUBE, StationAndZoneEnum.HAMMERSMITH, account);
        jorneyBusEarlToChelsea.setEndPoint(StationAndZoneEnum.WIMBLEDON);
        assertEquals(String.valueOf(TransportFare.BASIC_TUBE_FARE.subtract(TransportFare.ANY_TWO_ZONES_EXCLUDING_ZONE_1)), account.getAccountBalance(), new BigDecimal("0.001"));
    }

    @Test
    public void testChargeTubThreeoZones() {
        Account account = new Account(TransportFare.ANY_BUS_ROUTE);
        TransportFare fare = new TransportFare();
        TransportJourney jorneyBusEarlToChelsea = new TransportJourney();
        jorneyBusEarlToChelsea.setStartPoint(TransportEnum.TUBE, StationAndZoneEnum.HOLBORN, account);
        jorneyBusEarlToChelsea.setEndPoint(StationAndZoneEnum.WIMBLEDON);
        assertEquals(String.valueOf(TransportFare.BASIC_TUBE_FARE.subtract(TransportFare.ANY_THREE_ZONES)), account.getAccountBalance(), new BigDecimal("0.001"));
    }
}
