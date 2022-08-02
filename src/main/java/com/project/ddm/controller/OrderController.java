package com.project.ddm.controller;

import com.project.ddm.service.DispatchService;
import com.project.ddm.service.checkout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private DispatchService dispatchService;
    @Autowired
    private checkout checkout;

    @GetMapping(value = "/search/station/{lon}/{lat}")
    public Long getStationId(@PathVariable double lon, @PathVariable double lat) {
        return dispatchService.getClosestStationId(lon, lat);
    }

    @GetMapping(value = "/search/device/{stationId}/{deviceType}")
    public List<Long> getDevice(@PathVariable Long stationId, @PathVariable String deviceType) {
        return dispatchService.getAvailableDeviceIdsAtStation(stationId, deviceType);
    }

    @GetMapping(value = "/search/device/{lon1}/{lat1}/{lon2}/{lat2}/{weight}/{size}/{device}")
    public double getCost(@PathVariable double lon1, @PathVariable double lat1, @PathVariable double lon2, @PathVariable double lat2, @PathVariable double weight, @PathVariable double size, @PathVariable String device) {
        return checkout.getCost(weight, size, lon1, lat1, lon2, lat2, device);
    }
}
