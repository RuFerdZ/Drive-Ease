package com.backend.driveease.model;

import jakarta.persistence.*;

import java.time.ZonedDateTime;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Double price;

    @Column
    private String pickupLocation;

    @Column
    private String dropLocation;

    @Column
    private ZonedDateTime pickupDate;

    @Column
    private ZonedDateTime returnDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public ZonedDateTime getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(ZonedDateTime pickupDate) {
        this.pickupDate = pickupDate;
    }

    public ZonedDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(ZonedDateTime returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pickupLocation='" + pickupLocation + '\'' +
                ", dropLocation='" + dropLocation + '\'' +
                ", pickupDate=" + pickupDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
