package com.project.ddm.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class DeviceReservedDateKey implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long device_id;
    private LocalDate date;

    public DeviceReservedDateKey() {}

    public DeviceReservedDateKey(Long stay_id, LocalDate date) {
        this.device_id = device_id;
        this.date = date;
    }

    public Long getDevice_id() {
        return device_id;
    }

    public DeviceReservedDateKey setDevice_id(Long device_id) {
        this.device_id = device_id;
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
        return device_id.equals(that.device_id) && date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(device_id, date);
    }
}
