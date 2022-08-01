
package com.project.ddm.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "device")
public class Device implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double deliverDistance;

    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station;

    @OneToOne
    private Order order;

    private String deviceType;

    public Long getDeviceId() {
        return id;
    }

    public double getDeliverDistance() {
        return deliverDistance;
    }

    public Station getStation() {
        return station;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceId(Long id) {
        this.id = id;
    }

    public void setDeliverDistance(double deliverDistance) {
        this.deliverDistance = deliverDistance;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
}
