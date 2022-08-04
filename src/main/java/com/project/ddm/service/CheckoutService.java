package com.project.ddm.service;

import com.project.ddm.model.Station;
import com.project.ddm.repository.StationRepository;
import com.project.ddm.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CheckoutService {

    private DispatchService dispatchService;
    private StationRepository stationRepository;
    private TrackRepository trackRepository;

    @Autowired
    public CheckoutService(DispatchService dispatchService, StationRepository stationRepository, TrackRepository trackRepository) {
        this.dispatchService = dispatchService;
        this.stationRepository = stationRepository;
        this.trackRepository = trackRepository;
    }

    public double getCost(double weight, double size, double lon1, double lat1, double lon2, double lat2, String deviceType) {
        double ratio;

        Long stationId = dispatchService.getClosestStationId(lon1, lat1);

        Station station = stationRepository.findStationById(stationId);
        double OriginToStation = dispatchService.getDistance(lon1, lat1, station.getLongitude(), station.getLatitude());
        double DestToStation = dispatchService.getDistance(lon2, lat2, station.getLongitude(), station.getLatitude());
        double OriginToDest = dispatchService.getGlobeDistance(lat1, lon1, lat2, lon2);

        if (deviceType.equals("DRONE")) {
            ratio = 10;
        } else {
            ratio = 8;
        }

        return ratio * weight / size + 0.1 * (OriginToStation + OriginToDest + DestToStation);
    }

    public Long generateTrackingNumber() {
        Long trackId = Math.abs(new Random().nextLong());

        while (trackRepository.findOrderByTrackId(trackId) != null) {
            trackId = Math.abs(new Random().nextLong());
        }

        return trackId;
    }
}
