package com.example.cykelrytter.controllers;

import com.example.cykelrytter.services.IArtistService;
import com.example.cykelrytter.services.IStockService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {
    private IStockService stockService;
    public StockController(IStockService stockService){
        this.stockService = stockService;
    }
}
