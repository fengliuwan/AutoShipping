package com.project.ddm.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "device_reserve_date")
public class DeviceReserveDate {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private DeviceReservedDateKey id;

    @OneToOne
    @MapsId("device_id")
    private Device device;

    //deviceReserveDate.setSqlTime(java.sql.Time.valueOf("15:30:14"));
}
