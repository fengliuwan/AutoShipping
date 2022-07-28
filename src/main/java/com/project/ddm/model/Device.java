package com.project.ddm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "device")
@JsonDeserialize(builder = Device.Builder.class)

public class Device implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deviceId;
    private double deliverDistance;

    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<DeviceReserveDate> deviceReverseDates;

    @OneToOne
    private Order order;

    public  Device(){}

    private Device(Builder builder){
        this.deviceId = builder.deviceId;
        this.deliverDistance = builder.deliverDistance;
        this.station = builder.station;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public double getDeliverDistance() {
        return deliverDistance;
    }

    public void setDeliverDistance(double deliverDistance) {
        this.deliverDistance = deliverDistance;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public List<DeviceReserveDate> getDeviceReverseDates() {
        return deviceReverseDates;
    }

    public void setDeviceReverseDates(List<DeviceReserveDate> deviceReverseDates) {
        this.deviceReverseDates = deviceReverseDates;
    }

    public Order getOrders() {
        return order;
    }

    public void setOrders(Order orders) {
        this.order = orders;
    }

    public static class Builder{
        @JsonProperty("device_id")
        private Long deviceId;

        @JsonProperty("deliverDistance")
        private double deliverDistance;

        @JsonProperty("station")
        private Station station;

        @JsonProperty("deviceReverseDates")
        private List<DeviceReserveDate> deviceReverseDates;

        @JsonProperty
        private Order order;

        public Builder setDeviceId(Long deviceId){
            this.deviceId = deviceId;;
            return this;
        }

        public Builder setDeliverDistance(double deliverDistance){
            this.deliverDistance = deliverDistance;
            return this;
        }

        public Builder setStation(Station station){
            this.station = station;
            return this;
        }

        public Builder setDeviceReverseDate(List<DeviceReserveDate> deviceReverseDates){
            this.deviceReverseDates = deviceReverseDates;
            return this;
        }

        public Builder setOrders(Order order) {
            this.order = order;
            return this;
        }
    }
}