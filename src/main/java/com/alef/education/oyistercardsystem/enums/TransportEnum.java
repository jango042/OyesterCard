package com.alef.education.oyistercardsystem.enums;

public enum TransportEnum {
    BUS("Bus"),
    TUBE("Tube");

    private String transport;

    private TransportEnum(String zone)
    {
        this.transport = zone;
    }


    public String getTransport() {
        return transport;
    }
}
