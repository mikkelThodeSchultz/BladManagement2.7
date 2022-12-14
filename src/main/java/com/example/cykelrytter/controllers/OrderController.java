package com.example.cykelrytter.controllers;

import com.example.cykelrytter.model.Order;
import com.example.cykelrytter.model.Product;
import com.example.cykelrytter.services.IArtistService;
import com.example.cykelrytter.services.IOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
public class OrderController {
    private IOrderService orderService;
    public OrderController(IOrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/get/orderList")
    public ResponseEntity<Set<Order>> getOrder(){
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }

    @GetMapping ("/get/order")
    public ResponseEntity<Order> getOrder(@RequestParam Long productId){
        Optional<Order> targetOrder = orderService.findById(productId);
        if (targetOrder.isPresent()){
            return new ResponseEntity<>(targetOrder.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/create/order")
    public ResponseEntity<Order> create(@RequestBody Order order){
        return new ResponseEntity<>(orderService.save(order), HttpStatus.OK);
    }

}
