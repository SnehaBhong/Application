package com.carRental.service;

import com.carRental.entities.Car;
import com.carRental.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

@Autowired
private CarRepository carRepository;


    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

}

