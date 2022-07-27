package com.project.ddm.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "device_reserved_date")
public class DeViceReserveDate {
    @EmbeddedId
    private DeviceReservedDateKey id;

    @ManyToOne
    //@MapsId("deviceId")
    private Device device;

    public DeViceReserveDate() {}

    public DeViceReserveDate(DeviceReservedDateKey id, Device device) {
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
