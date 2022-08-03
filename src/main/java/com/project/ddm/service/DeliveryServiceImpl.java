package com.project.ddm.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DeliveryServiceImpl {





    public List<Long> getPickUpTime() {
        List<Long> list = new ArrayList<>();
        //机器人

        double robotDistance = getRobotDistance(sendingLon, sendingLat, stationLon, stationLat);
        double robotTime = robotDistance / 33.6;
        list.add(Double.valueOf(robotTime).longValue());

        // 无人机

        double droneDistance = getDroneDistance(sendingLon, sendingLat, stationLon, stationLat);
        double droneTime = droneDistance/ 33.6;
        list.add(Double.valueOf(droneTime).longValue());
        return list;
    }


    public List<Long> getDeliveryTime() {
        List<Long> list = new ArrayList<>();


        double robotDistance = getRobotDistance(sendingLon, sendingLat, receivingLon, receivingLat);
        double robotTime = robotDistance / 33.6;
        list.add(Double.valueOf(robotTime).longValue());



        double droneDistance = getDroneDistance(sendingLon, sendingLat, receivingLon, receivingLat);
        double droneTime = droneDistance / 33.6;
        list.add(Double.valueOf(droneTime).longValue());
        return list;
    }


    private double getDroneDistance(double lon1, double lat1, double lon2, double lat2) {
        double b = getLatitudeDistance(lat1, lat2);
        double a = getLongitudeDistance(lon1, lon2);
        return Math.sqrt((a * a + b * b));
    }



    private double getRobotDistance(double lon1, double lat1, double lon2, double lat2) {
        double b = getLatitudeDistance(lat1, lat2);
        double a = getLongitudeDistance(lon1, lon2);
        return a + b;
    }


    private double getLongitudeDistance(double lon1, double lon2){
        double jl_wd = 111712.69150641055729984301412873; // 每纬度单位米;
        return Math.abs((lon1- lon2) * jl_wd);
    }


    private double getLatitudeDistance(double lat1, double lat2){
        double jl_jd = 102834.74258026089786013677476285; // 每经度单位米;
        return Math.abs((lat1- lat2) * jl_jd);
    }

}
