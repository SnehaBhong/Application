package com.carRental.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking extends BaseEntity{      //Booking = Order

   // private Long bookingId;
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

    @OneToOne
    private Driver driver;

 //one car for one booking
 @JsonIgnore
 @OneToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "car_id")
 private Car car;

 //One User Many Bookings
 @ManyToOne(targetEntity = User.class)
 @JoinColumn(name = "user_id")
 private User user ;

 private int cardNo;

}
