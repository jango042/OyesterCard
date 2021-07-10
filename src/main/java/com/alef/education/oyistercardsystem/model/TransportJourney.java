package com.alef.education.oyistercardsystem.model;

import com.alef.education.oyistercardsystem.enums.StationAndZoneEnum;
import com.alef.education.oyistercardsystem.enums.TransportEnum;
import lombok.Data;

@Data
public class TransportJourney {
    private StationAndZoneEnum startPoint;
    private StationAndZoneEnum endPoint;
    private TransportEnum transport;

    private Account account;


    public void setStartPoint(TransportEnum transport, StationAndZoneEnum startPoint, Account account) {
        try {
            TransportFare.validade(transport, account);
            TransportFare.chargeMax(transport, account);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        this.transport = transport;
        this.account = account;
        this.startPoint = startPoint;
    }

    public void setEndPoint( StationAndZoneEnum endPoint)throws Exception {

        this.endPoint = endPoint;
        TransportFare.charge(transport,this, account);
    }
}
