package com.project.ddm.controller;

import com.project.ddm.service.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private DispatchService dispatchService;

    @GetMapping(value = "/search/station/{lon}/{lat}")
    public Long getStationId(@PathVariable double lon, @PathVariable double lat) {
        return dispatchService.getClosestStationId(lon, lat);
    }

    @GetMapping(value = "/search/device/{stationId}/{deviceType}")
    public List<Long> getDevice(@PathVariable Long stationId, @PathVariable String deviceType) {
        return dispatchService.getAvailableDeviceIdsAtStation(stationId, deviceType);
    }
}
