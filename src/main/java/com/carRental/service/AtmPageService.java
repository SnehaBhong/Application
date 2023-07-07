package com.carRental.service;

import com.carRental.dto.FinalConfirmRequest;
import com.carRental.dto.FinalConfirmResponse;
import com.carRental.entities.Booking;
import com.carRental.entities.Car;
import com.carRental.entities.Driver;
import com.carRental.entities.User;
import com.carRental.repositories.BookingRepository;
import com.carRental.repositories.CarRepository;
import com.carRental.repositories.DriverRepository;
import com.carRental.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalTime;

@Slf4j
@Service
public class AtmPageService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private CarRepository carRepository;

    public FinalConfirmResponse placeOrder(FinalConfirmRequest finalConfirmRequest, HttpSession session) {
        Booking booking = new Booking();
        FinalConfirmResponse res = new FinalConfirmResponse();
        Object userEmail = session.getAttribute("UserEmail");
        User user = userRepository.findByEmail((String) userEmail);

        Driver driver = driverRepository.findById(finalConfirmRequest.getDriverId()).get();

        Car car = carRepository.findById((Integer) session.getAttribute("carId")).get();

        booking.setCar(car);
        booking.setDriver(driver);

        booking.setUser(userRepository.findByEmail((String) session.getAttribute("UserEmail")));
        booking.setPickUpLocation((String) session.getAttribute("pickUpLocation"));
        booking.setDropLocation((String) session.getAttribute("dropLocation"));
        booking.setPickUpDate((LocalDate) session.getAttribute("pickUpDate"));
        booking.setPickUpTime((LocalTime) session.getAttribute("pickUpTime"));
        booking.setDropDate((LocalDate) session.getAttribute("dropDate"));
        booking.setPassengerCapacity((Integer) session.getAttribute("passengerCapacity"));
        booking.setDays((Integer) session.getAttribute("days"));
        booking.setNumBags((Integer) session.getAttribute("numBags"));
        booking.setCardNo(finalConfirmRequest.getCardNo());

        Integer days = booking.getDays();
        int charges = driver.getCharges();
        Integer totalPrice = booking.getTotalPrice();
        totalPrice=totalPrice+(charges*days);
        booking.setTotalPrice(totalPrice);

        bookingRepository.save(booking);

        res.setFname(user.getFname());
        res.setLname(user.getLname());
        res.setEmail(user.getEmail());
        res.setDriverImg(driver.getDriverImg());
        res.setDriverName(driver.getDriverName());
        res.setDriverMobNo(driver.getDriverMobNo());
        res.setCharges(driver.getCharges());

        res.setCarCompany(car.getCarCompany());
        res.setCarColor(car.getCarColor());
        res.setCarImg(car.getCarImg());
        res.setCarModel(car.getCarModel());
        res.setCarType(car.getCarType());
        res.setFuelType(car.getFuelType());
        res.setPickUpLocation(booking.getPickUpLocation());
        res.setDropLocation(booking.getDropLocation());
        res.setPickUpDate(booking.getPickUpDate());
        res.setPickUpTime(booking.getPickUpTime());
        res.setDropDate(booking.getDropDate());
        res.setPassengerCapacity(booking.getPassengerCapacity());
        res.setMembers(booking.getMembers());
        res.setDays(booking.getDays());
        res.setCardNo(finalConfirmRequest.getCardNo());

        return res;
    }
}




