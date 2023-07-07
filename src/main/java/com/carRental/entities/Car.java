package com.carRental.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car extends BaseEntity{

    // private Long carId;
    private String carCompany;
    private String carColor;
    private String carModel;
    private String carType;
    private String carImg;
    private String car360;
    private String carOwner;
    private String numPlate;
    private String regDate;
    private String insurance;
    private String insuranceValidity;
    private int passengerCapacity;
    private String fuelType;
    private String feature;
    private int totalRunning;
    private int charges;

}
