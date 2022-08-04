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
    private long id;

    private double longitude;
    private double latitude;

    @OneToMany (mappedBy = "station", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Device> devices;

    public long getStationId() {
        return id;
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
        this.id = stationId;
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
