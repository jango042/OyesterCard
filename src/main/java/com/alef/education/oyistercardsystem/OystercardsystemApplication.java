package com.alef.education.oyistercardsystem;

import com.alef.education.oyistercardsystem.model.StationAndZones;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class OystercardsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OystercardsystemApplication.class, args);

	}

	@Bean
	public List<StationAndZones> initializeStationAndZone() {
		List<StationAndZones> stationAndZonesList = new ArrayList<>();
		Map<String, List<Integer>> station1 = new HashMap<>();
		station1.put("Holborn", Arrays.asList(1));
		Map<String, List<Integer>> station2 = new HashMap<>();
		station2.put("Earl’s Court", Arrays.asList(1,2));
		Map<String, List<Integer>> station3 = new HashMap<>();
		station3.put("Wimbledon", Arrays.asList(3));
		Map<String, List<Integer>> station4 = new HashMap<>();
		station4.put("Hammersmith", Arrays.asList(2));

		StationAndZones stationAndZones1 = new StationAndZones(station1);
		stationAndZonesList.add(stationAndZones1);
		StationAndZones stationAndZones2 = new StationAndZones(station2);
		stationAndZonesList.add(stationAndZones2);
		StationAndZones stationAndZones3 = new StationAndZones(station3);
		stationAndZonesList.add(stationAndZones3);
		StationAndZones stationAndZones4 = new StationAndZones(station4);
		stationAndZonesList.add(stationAndZones4);

		return stationAndZonesList;

	}
}
