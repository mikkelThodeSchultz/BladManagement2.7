package com.example.cykelrytter.controllers;

import com.example.cykelrytter.services.IArtistService;
import com.example.cykelrytter.services.IOrderService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private IOrderService orderService;
    public OrderController(IOrderService orderService){
        this.orderService = orderService;
    }
}
