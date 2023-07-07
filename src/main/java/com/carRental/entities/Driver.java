package com.carRental.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Driver extends BaseEntity {

    //private Long driverId;
    private String driverImg;
    private String driverName;
    private String drivingExperience;
    private String driverMobNo;
    private String availability;
    private String food;
    private String smoke;
    private String drink;
    private int charges;

//one driver for one car

     @OneToOne(targetEntity = Car.class)
     @JoinColumn(name = "carId")
     private Car car ;

}
