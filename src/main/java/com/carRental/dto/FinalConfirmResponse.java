package com.carRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinalConfirmResponse {
    private String email;
    private String fname;
    private String lname;

    private String driverImg;
    private String driverName;
    private String driverMobNo;
    private int charges;
    private long finalCost;
    private  String carCompany;
    private  String carColor;
    private  String carModel;
    private String carType;
    private String carImg;
    private String fuelType;
    private  String pickUpLocation;
    private  String dropLocation;
    private LocalTime pickUpTime;
    private LocalDate pickUpDate;
    private LocalDate dropDate;
    private int passengerCapacity;
    private int members;
    private int days;
    private int cardNo;
    private int id;

}
