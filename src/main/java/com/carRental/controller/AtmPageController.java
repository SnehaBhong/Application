package com.carRental.controller;

import com.carRental.dto.FinalConfirmRequest;
import com.carRental.dto.FinalConfirmResponse;
import com.carRental.service.AtmPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/finalConfirm")            //>>> ATM Page   POST = /finalConfirm
public class AtmPageController {

    @Autowired
    private AtmPageService atmPageService;

    @PostMapping("")
    public FinalConfirmResponse placeOrder(@RequestBody FinalConfirmRequest finalConfirmRequest, HttpSession session){
       return atmPageService.placeOrder(finalConfirmRequest,session);

    }
}
