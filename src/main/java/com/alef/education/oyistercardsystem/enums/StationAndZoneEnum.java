package com.alef.education.oyistercardsystem.enums;

public enum StationAndZoneEnum {

    HOLBORN("1"),
    EARLS_COURT("1,2"),
    WIMBLEDON("3"),
    HAMMERSMITH("2");

    private String zone;

    private StationAndZoneEnum(String zone)
    {
        this.zone = zone;
    }


    public String getZone() {
        return zone;
    }
}
