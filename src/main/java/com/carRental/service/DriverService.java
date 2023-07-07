package com.carRental.service;

import com.carRental.entities.Driver;
import com.carRental.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();

    }

    public Optional<Driver> allDrivers(int driverId) {
        return driverRepository.findById(driverId);
    }
}
