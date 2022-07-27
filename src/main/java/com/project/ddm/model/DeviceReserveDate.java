package com.project.ddm.model;

import javax.persistence.*;

@Entity
@Table(name = "device_reserved_date")
public class DeviceReserveDate {
    @EmbeddedId
    private DeviceReservedDateKey id;

    @ManyToOne
    @MapsId("deviceId")
    private Device device;

    public DeviceReserveDate() {}

    public DeviceReserveDate(DeviceReservedDateKey id, Device device) {
        this.id = id;
        this.device = device;
    }

    public DeviceReservedDateKey getId() {
        return id;
    }

    public Device getStay() {
        return device;
    }
}
