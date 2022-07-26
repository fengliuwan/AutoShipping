package com.project.ddm.service;

import com.project.ddm.model.Station;
import com.project.ddm.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispatchService {

    private StationRepository stationRepository;

    @Autowired
    public DispatchService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    /**
     * @param lon delivery origin lontitude
     * @param lat delivery origin latitude
     * @return id of the station closest to sender's location
     */
    public int getClosestStationId(double lon, double lat) {
        List<Station> stations = stationRepository.findAll();
        int bestId = -1;
        double bestDist = Double.MAX_VALUE;

        // get station closest to lon lat
        for (Station station : stations) {
            double stationLon = station.getLongitude();
            double stationLat = station.getLatitude();
            double dist = getDistance(lon, lat, stationLon, stationLat);
            if (dist < bestDist) {
                bestDist = dist;
                bestId = station.getStationId();
            }
        }

        return bestId;
    }

    /**
     * @param lon delivery origin's longitude
     * @param lat delivery origin's latitude
     * @param stationLon station's longitude
     * @param stationLat station's latitude
     * @return distance from sender's location to station's location
     */
    private double getDistance(double lon, double lat, double stationLon, double stationLat) {
        return Math.abs(lon - stationLon) + Math.abs(lat - stationLat);
    }
}
