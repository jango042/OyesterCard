package com.alef.education.oyistercardsystem.model;


import com.alef.education.oyistercardsystem.enums.TransportEnum;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class TransportFare {
    public static final BigDecimal ANY_BUS_ROUTE = new BigDecimal("1.80");
    public static final BigDecimal ANY_ONE_ZONE_OUTSIDE_ZONE_1 = new BigDecimal("2.00");
    public static final BigDecimal ANYWHERE_IN_ZONE_1 = new BigDecimal("2.50");
    public static final BigDecimal ANY_TWO_ZONES_INCLUDING_ZONE_1 = new BigDecimal("3.00");
    public static final BigDecimal ANY_TWO_ZONES_EXCLUDING_ZONE_1 = new BigDecimal("2.25");
    public static final BigDecimal ANY_THREE_ZONES = new BigDecimal("3.20");
    public static final BigDecimal OYSTER_CARD_BALANCE = new BigDecimal("30.0");
    public static final BigDecimal ANY_ZONE_OUTSIDE_ZONE_ONE_FARE = new BigDecimal("2.00");
    public static final BigDecimal BASIC_TUBE_FARE = new BigDecimal("3.20");


    public static void validade(TransportEnum transport, Account account){

        try {
            if (transport.equals(TransportEnum.BUS))
                account.validade(ANY_BUS_ROUTE);

            if (transport.equals(TransportEnum.TUBE))
                account.validade(BASIC_TUBE_FARE);
        } catch (Exception e) {
            log.info(e.getMessage());
        }


    }

    public static void chargeMax(TransportEnum transport, Account account) {
        if (transport.equals(TransportEnum.BUS))
            account.out(ANY_BUS_ROUTE);

        if (transport.equals(TransportEnum.TUBE))
            account.out(BASIC_TUBE_FARE);

    }

    public static void charge(TransportEnum transport, TransportJourney journey, Account account) {

        if (transport.equals(TransportEnum.TUBE)) {

            int count = countZones(journey);

            if ( isOneZones(count) && isZoneTwo(journey)) {

                account.in(BASIC_TUBE_FARE.subtract(ANY_ZONE_OUTSIDE_ZONE_ONE_FARE) );

            }else if (haveZoneOne(journey) && isOneZones(count)) {

                account.in(BASIC_TUBE_FARE.subtract(ANYWHERE_IN_ZONE_1));

            } else if (!haveZoneOne(journey) && isOneZones(count)) {

                account.in(BASIC_TUBE_FARE.subtract(ANY_ONE_ZONE_OUTSIDE_ZONE_1));

            } else if (haveZoneOne(journey) && isTwoZones(count)) {

                account.in(BASIC_TUBE_FARE.subtract(ANY_TWO_ZONES_INCLUDING_ZONE_1));

            } else if (!haveZoneOne(journey) && isTwoZones(count)) {

                account.in(BASIC_TUBE_FARE.subtract(ANY_TWO_ZONES_EXCLUDING_ZONE_1));

            } else if (isThreeZones(count)) {

                account.in(BASIC_TUBE_FARE.subtract(ANY_THREE_ZONES) );

            }

        } else if (transport.equals(TransportEnum.BUS)) {
            account.in(new BigDecimal(0));
        }

    }

    private static boolean isZoneTwo(TransportJourney journey) {
        if (journey.getEndPoint().getZone().contains("2") && journey.getStartPoint().getZone().contains("2"))
            return true;
        return false;
    }

    private static int countZones(TransportJourney journey) {
        String[] zonesStart = journey.getStartPoint().getZone().split(",");
        String[] zonesEnd = journey.getEndPoint().getZone().split(",");
        int x = 10;
        for (int i = 0; i < zonesStart.length; i++) {
            for (int j = 0; j < zonesEnd.length; j++) {
                int z = Integer.parseInt(zonesStart[i]);
                int y = Integer.parseInt(zonesEnd[j]);
                z = Math.abs(z - y);
                if (z < x)
                    x = z;
            }
        }

        return Math.abs(x);
    }

    private static boolean isThreeZones(int count) {
        if (count == 2)
            return true;
        return false;
    }

    private static boolean isTwoZones(int count) {
        if (count == 1)
            return true;
        return false;
    }

    private static boolean isOneZones(int count) {
        if (count == 0)
            return true;
        return false;
    }

    private static boolean haveZoneOne(TransportJourney journey) {
        if (journey.getEndPoint().getZone().contains("1") || journey.getStartPoint().getZone().contains("1"))
            return true;
        return false;
    }
}
