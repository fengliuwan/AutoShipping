package com.project.ddm.controller;

import com.project.ddm.model.Station;
import com.project.ddm.repository.StationRepository;
import com.project.ddm.service.DeliveryService;
import com.project.ddm.service.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GenerateOrderController {

    private DeliveryService deliveryService;

    private DispatchService dispatchService;

    private StationRepository stationRepository;

    @Autowired
    public GenerateOrderController(DeliveryService deliveryService,
                                   DispatchService dispatchService,
                                   StationRepository stationRepository) {
        this.deliveryService = deliveryService;
        this.dispatchService = dispatchService;
        this.stationRepository = stationRepository;
    }


    @GetMapping(value = "/generateOrder")
    public Map<String, Object> generateOrder(
            @RequestParam(name = "sending_lat") double sendingLat,
            @RequestParam(name = "sending_lon") double sendingLon,
            @RequestParam(name = "receiving_lat") double receivingLat,
            @RequestParam(name = "receiving_lon") double receivingLon) {

        Long stationId = dispatchService.getClosestStationId(sendingLon, sendingLat);
        System.out.println(stationId);
        Station station = stationRepository.findStationById(stationId);
        double stationLat = station.getLatitude();
        double stationLon = station.getLongitude();
        List<Long> pickUpTime = deliveryService.getPickUpTime(sendingLon, sendingLat, stationLon, stationLat);
        List<Long> deliveryTime = deliveryService.getDeliveryTime(sendingLon, sendingLat, receivingLon, receivingLat);

        Map<String, Object> map = new HashMap<>(2);
        map.put("pick_up_time", pickUpTime);
        map.put("delivery_time", deliveryTime);
        return map;
    }
}
