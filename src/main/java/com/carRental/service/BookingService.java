package com.carRental.service;

import com.carRental.dto.FinalBookingResponseDto;
import com.carRental.dto.RegisterBookingRequest;
import com.carRental.dto.RegisterBookingResponse;
import com.carRental.entities.Booking;
import com.carRental.entities.Car;
import com.carRental.entities.Driver;
import com.carRental.entities.User;
import com.carRental.repositories.BookingRepository;
import com.carRental.repositories.CarRepository;
import com.carRental.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BookingService {
    @Autowired
    HttpSession session;

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookingRepository bookingRepository;

    public Optional<Car> bookCarWithId(int id) {
        return carRepository.findById(id);

    }

    public RegisterBookingResponse bookMyCar(RegisterBookingRequest registerBookingRequest, HttpSession session) {
        RegisterBookingResponse registerBookingResponse = new RegisterBookingResponse();
        log.info(registerBookingRequest.getId() + "");
        Car car = carRepository.findById(registerBookingRequest.getId()).get();
        session.setAttribute("car", registerBookingRequest.getId());
        log.info(car.toString());

        Object userEmail = session.getAttribute("UserEmail");
        System.out.println(userEmail);
        User byEmail = userRepository.findByEmail((String) userEmail);
        Logger logger = LoggerFactory.getLogger("bookingService.class");

        session.setAttribute("carId", registerBookingRequest.getId());
        session.setAttribute("pickUpLocation", registerBookingRequest.getPickUpLocation());
        session.setAttribute("dropLocation", registerBookingRequest.getDropLocation());
        session.setAttribute("dropDate", registerBookingRequest.getDropDate());
        session.setAttribute("passengerCapacity", registerBookingRequest.getPassengerCapacity());
        session.setAttribute("members", registerBookingRequest.getMembers());
        session.setAttribute("pickUpTime", registerBookingRequest.getPickUpTime());
        session.setAttribute("days", registerBookingRequest.getDays());
        session.setAttribute("numBags", registerBookingRequest.getNumBags());
        session.setAttribute("totalPrice", registerBookingRequest.getTotalPrice());

        registerBookingResponse.setCarCompany(car.getCarCompany());
        registerBookingResponse.setCarColor(car.getCarColor());
        registerBookingResponse.setCarOwner(car.getCarOwner());
        registerBookingResponse.setCarModel(car.getCarModel());
        registerBookingResponse.setCarType(car.getCarType());
        registerBookingResponse.setCarImg(car.getCarImg());
        registerBookingResponse.setNumPlate(car.getNumPlate());
        registerBookingResponse.setInsuranceValidity(car.getInsuranceValidity());
        registerBookingResponse.setFuelType(car.getFuelType());
        registerBookingResponse.setFeature(car.getFeature());
        registerBookingResponse.setId(car.getId());
        registerBookingResponse.setPickUpLocation(registerBookingRequest.getPickUpLocation());
        registerBookingResponse.setDropLocation(registerBookingRequest.getDropLocation());
        registerBookingResponse.setPickUpDate(registerBookingRequest.getPickUpDate());
        registerBookingResponse.setDropDate(registerBookingRequest.getDropDate());
        registerBookingResponse.setPassengerCapacity(registerBookingRequest.getPassengerCapacity());
        registerBookingResponse.setMembers(registerBookingRequest.getMembers());
        registerBookingResponse.setPickUpTime(registerBookingRequest.getPickUpTime());
        registerBookingResponse.setDays(registerBookingRequest.getDays());
        registerBookingResponse.setNumBags(registerBookingRequest.getNumBags());
        registerBookingResponse.setTotalPrice(registerBookingRequest.getTotalPrice());

        System.out.println(registerBookingResponse);
        return registerBookingResponse;

    }

    public List<FinalBookingResponseDto> getAllBookings(String email) {
      //  User user = userRepository.findByEmail(email);


        List<Booking> bookingList = bookingRepository.findByUserEmail(email);
       List<FinalBookingResponseDto> collect = bookingList.stream().map(x -> convertConfirmBookingToDTO(x, x.getUser(), x.getDriver())).collect(Collectors.toList());

        return collect;

    }

    public FinalBookingResponseDto convertConfirmBookingToDTO(Booking booking,User user,Driver driver){
        System.out.println("before :");
        System.out.println(booking);
        System.out.println(user);
        System.out.println(driver);
    FinalBookingResponseDto finalBookingResponseDTO=new FinalBookingResponseDto(user.getFname(), user.getLname(), user.getEmail(),driver.getDriverImg(),
            driver.getDriverMobNo(), driver.getDriverName(), driver.getCharges(), booking.getCar().getCarCompany(),
            booking.getCar().getCarColor(),booking.getCar().getCarModel(),booking.getCar().getCarType(),booking.getCar().getCarImg(),
            booking.getCar().getFuelType(),booking.getPickUpLocation(), booking.getDropLocation(),booking.getPickUpTime(),booking.getPickUpDate(),
            booking.getDropDate(),booking.getCar().getPassengerCapacity(),booking.getMembers(),booking.getDays(), booking.getCardNo(),booking.getTotalPrice());

        System.out.println("after :"+finalBookingResponseDTO);
        return  finalBookingResponseDTO;

    }
}

