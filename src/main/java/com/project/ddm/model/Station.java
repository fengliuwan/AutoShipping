package com.project.ddm.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "station")
public class Station implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int stationId;

    private double longitude;
    private double latitude;

    @OneToMany (mappedBy = "station", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Device> devices;

    public int getStationId() {
        return stationId;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public List<Device> getDeviceIds() {
        return devices;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setDeviceIds(List<Device> devices) {
        this.devices = devices;
    }
}