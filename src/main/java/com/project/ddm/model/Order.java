package com.project.ddm.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "aorder")
@JsonDeserialize(builder = Order.Builder.class)
public class Order implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    private Long trackId;

    private Double weight;

    private Double price;

    private String sendingAddress;

    private String receivingAddress;

    public Order() {}

    private Order(Builder builder) {
        this.orderId = builder.orderId;
        this.trackId = builder.trackId;
        this.weight = builder.weight;
        this.price = builder.price;
        this.sendingAddress = builder.sendingAddress;
        this.receivingAddress = builder.receivingAddress;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getTrackId() {
        return trackId;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getPrice() {
        return price;
    }

    public String getSendingAddress() {
        return sendingAddress;
    }

    public String getReceivingAddress() {
        return receivingAddress;
    }

    public static class Builder {

        @JsonProperty("order_id")
        private Long orderId;

        @JsonProperty("track_id")
        private Long trackId;

        @JsonProperty("weight")
        private Double weight;

        @JsonProperty("price")
        private Double price;

        @JsonProperty("sending_address")
        private String sendingAddress;

        @JsonProperty("receiving_address")
        private String receivingAddress;

        public Builder setOrderId(Long orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setTrackId(Long trackId) {
            this.trackId = trackId;
            return this;
        }

        public Builder setWeight(Double weight) {
            this.weight = weight;
            return this;
        }

        public Builder setPrice(Double price) {
            this.price = price;
            return this;
        }

        public Builder setSendingAddress(String sendingAddress) {
            this.sendingAddress = sendingAddress;
            return this;
        }

        public Builder setReceivingAddress(String receivingAddress) {
            this.receivingAddress = receivingAddress;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}