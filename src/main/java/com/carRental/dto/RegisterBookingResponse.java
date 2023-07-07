package com.carRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterBookingResponse {
    private int Id;
    private String carCompany;
    private String carColor;
    private String carModel;
    private String carType;
    private String carOwner;
    private String carImg;
    private String numPlate;
    private String insuranceValidity;
    private String fuelType;
    private String feature;
    private String pickUpLocation;
    private String dropLocation;
    private LocalTime pickUpTime;
    private LocalDate pickUpDate;
    private LocalDate dropDate;
    private int passengerCapacity;
    private int members;
    private int days;
    private int numBags;
    private int totalPrice;

}
