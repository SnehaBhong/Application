package com.carRental.controller;

import com.carRental.dto.FinalBookingResponseDto;
import com.carRental.dto.RegisterBookingRequest;
import com.carRental.dto.RegisterBookingResponse;
import com.carRental.entities.Car;
import com.carRental.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;


    @GetMapping("/book-car/{id}")       // >>> Booking Form Page        GET = /book-car/6
    public Optional<Car> bookCarWithId (@PathVariable int id) {
      return bookingService.bookCarWithId(id);

    }

    @PostMapping("/book-now")              //Booking Form Page     POST = /book-now

    public RegisterBookingResponse bookCar(@RequestBody RegisterBookingRequest registerBookingRequest, HttpSession session) {
      return bookingService.bookMyCar(registerBookingRequest,session);
    }
    @GetMapping("/ticket-details/{email}")
    public List<FinalBookingResponseDto> getAllBookings(@PathVariable String email){
        return bookingService.getAllBookings(email);

    }
}
