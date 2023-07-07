package com.carRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinalBookingResponseDto {
    private String email;
    private String fname;
    private String lname;

    private String driverImg;
    private String driverName;
    private String driverMobNo;
    private int charges;

    private String carCompany;
    private String carColor;
    private String carModel;
    private String carType;
    private String carImg;
    private String fuelType;

    private String pickUpLocation;
    private String dropLocation;
    private LocalTime pickUpTime;
    private LocalDate pickUpDate;
    private LocalDate dropDate;
    private int passengerCapacity;
    private int members;
    private int days;
    private int cardNo;


    public FinalBookingResponseDto(String fname, String lname, String email, String driverImg, String driverMobNo, String driverName, int charges, String carCompany, String carColor, String carModel, String carType, String carImg, String fuelType, String pickUpLocation, String dropLocation, LocalTime pickUpTime, LocalDate pickUpDate, LocalDate dropDate, int passengerCapacity, int members, int days, int cardNo, int totalPrice) {
    }
}
