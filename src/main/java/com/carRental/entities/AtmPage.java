package com.carRental.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    public class AtmPage extends BaseEntity{

        // private Long paymentId;
        private int cardNo;

        private User user;

        @OneToOne
        private Car car;

        @OneToOne
        @JoinColumn(name = "driverId")
        private Driver driver ;

        @OneToOne
        @JoinColumn(name = "bookingId")
        private Booking booking ;
    }


