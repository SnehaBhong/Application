package com.carRental.controller;

import com.carRental.entities.Car;
import com.carRental.repositories.CarRepository;
import com.carRental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @Autowired
    private CarRepository carRepository;

    @PostMapping("/cars")          // post = /cars
    public Car addCars (@RequestBody Car car){
            return carRepository.save(car);
        }

    // GET endpoint to retrieve all cars by id
    @GetMapping("/cars")        //Get = /cars
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }



}
