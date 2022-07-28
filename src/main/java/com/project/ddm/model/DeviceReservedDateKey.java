package com.project.ddm.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class DeviceReservedDateKey implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long deviceId;
    private LocalDate date;

    public DeviceReservedDateKey() {}

    public DeviceReservedDateKey(Long stay_id, LocalDate date) {
        this.deviceId = deviceId;
        this.date = date;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public DeviceReservedDateKey setStay_id(Long deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public DeviceReservedDateKey setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceReservedDateKey that = (DeviceReservedDateKey) o;
        return deviceId.equals(that.deviceId) && date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, date);
    }
}
