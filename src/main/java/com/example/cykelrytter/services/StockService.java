package com.example.cykelrytter.services;

import com.example.cykelrytter.model.Image;
import com.example.cykelrytter.model.Stock;
import com.example.cykelrytter.repositories.StockRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
@Service
public class StockService implements IStockService{

    private StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Set<Stock> findAll() {
        return null;
    }

    @Override
    public Stock save(Stock object) {
        return null;
    }

    @Override
    public void delete(Stock object) {

    }

    @Override
    public void deleteById(Long aLong) {
    }

    @Override
    public Optional<Stock> findById(Long aLong) {
        return Optional.empty();
    }
}
