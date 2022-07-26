package com.project.ddm.controller;

import com.project.ddm.service.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private DispatchService dispatchService;

    @GetMapping(value = "/search/{lon}/{lat}")
    public int getStation(@PathVariable double lon, @PathVariable double lat) {
        return dispatchService.getClosestStationId(lon, lat);
    }
}
