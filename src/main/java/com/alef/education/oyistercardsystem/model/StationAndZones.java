package com.alef.education.oyistercardsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StationAndZones implements Serializable {

    private Map<String , List<Integer>> stationZone;
}
