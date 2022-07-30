package com.project.ddm.service;

import com.project.ddm.model.Device;
import com.project.ddm.model.Station;
import com.project.ddm.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class DispatchService {

    private StationRepository stationRepository;


    @Autowired
    public DispatchService(StationRepository stationRepository,
                           DeviceReserveDateRepository deviceReserveDateRepository) {
        this.stationRepository = stationRepository;
        this.deviceReserveDateRepository = deviceReserveDateRepository;
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

    public List<Long> getAvailableDeviceIdsAtStation (int stationId, DeviceType type) {
        Station station = stationRepository.findStationById(stationId);
        List<Device> devices = new ArrayList<>();

        // get device that matches type
        for (Device device : station.getDevices()) {
            if (device.getDeviceType() == type) {
                devices.add(device);
            }
        }
        List<Long> deviceIds = new ArrayList<>();
        for (Device device : devices) {
            deviceIds.add(device.getDeviceId());
        }

        Set<Long> reservedDeviceIds = deviceReserveDateRepository.findByIdAndDateBefore(deviceIds, LocalDate.now());

        List<Long> filteredDeviceIds = new ArrayList<>();
        for (Long id : deviceIds) {
            if (!reservedDeviceIds.contains(id)) {
                filteredDeviceIds.add(id);
            }
        }
        return filteredDeviceIds;
    }
}
