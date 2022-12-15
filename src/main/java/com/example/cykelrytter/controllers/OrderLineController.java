package com.example.cykelrytter.controllers;

import com.example.cykelrytter.model.OrderLine;
import com.example.cykelrytter.services.IOrderLineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin
public class OrderLineController {

    private IOrderLineService orderLineService;

    public OrderLineController(IOrderLineService orderLineService){
        this.orderLineService = orderLineService;
    }

    @GetMapping("/get/orderLines")
    public ResponseEntity<Set<OrderLine>> getOrderLines(){
        return new ResponseEntity<>(orderLineService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/get/orderLine")
    public ResponseEntity<OrderLine> getOrderLine(@RequestParam long orderLineID){
        Optional<OrderLine> targetOrderLine = orderLineService.findById(orderLineID);
        if (targetOrderLine.isPresent()){
            return new ResponseEntity<>(targetOrderLine.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/create/orderLine")
    public ResponseEntity<OrderLine> create(@RequestBody OrderLine orderLine){
        return new ResponseEntity<>(orderLineService.save(orderLine), HttpStatus.OK);
    }
}
