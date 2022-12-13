package com.example.cykelrytter.controllers;

import com.example.cykelrytter.model.Product;
import com.example.cykelrytter.model.StockItem;
import com.example.cykelrytter.services.IStockItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
public class StockItemController {
    private IStockItemService stockService;
    public StockItemController(IStockItemService stockService){
        this.stockService = stockService;
    }

    @GetMapping("/get/stockItemList")
    public ResponseEntity<Set<StockItem>> getStockItems(){
        return new ResponseEntity<>(stockService.findAll(), HttpStatus.OK);
    }

    @GetMapping ("/get/stockItem")
    public ResponseEntity<StockItem> getStockItem(@RequestParam Long stockItemId){
        Optional<StockItem> targetStockItem = stockService.findById(stockItemId);
        if (targetStockItem.isPresent()){
            return new ResponseEntity<>(targetStockItem.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/create/stockItem")
    public ResponseEntity<StockItem> create(@RequestBody StockItem stockItem){
        return new ResponseEntity<>(stockService.save(stockItem), HttpStatus.OK);
    }
}
