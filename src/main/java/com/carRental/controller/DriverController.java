package com.carRental.controller;

import com.carRental.entities.Driver;
import com.carRental.repositories.DriverRepository;
import com.carRental.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/drivers")            // >>> Driver's Page         GET = /drivers
public class DriverController {

    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private DriverService driverService;


    @PostMapping("")
    public Driver addDrivers (@RequestBody Driver driver){
        return driverRepository.save(driver);
    }

    // GET endpoint to retrieve all drivers
    @GetMapping("")
    public List<Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @GetMapping("{driverId}")
    public Optional<Driver> getDriver(@PathVariable int driverId) {
        return driverService.allDrivers(driverId);
    }
}
