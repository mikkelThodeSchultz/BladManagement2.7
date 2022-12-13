package com.example.cykelrytter.services;

import com.example.cykelrytter.model.StockItem;
import com.example.cykelrytter.repositories.StockItemRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
public class StockItemService implements IStockItemService {

    private StockItemRepository stockItemRepository;

    public StockItemService(StockItemRepository stockRepository) {
        this.stockItemRepository = stockItemRepository;
    }

    @Override
    public Set<StockItem> findAll() {
        Set <StockItem> stockItems = new HashSet<>(stockItemRepository.findAll());
        return stockItems;
    }

    @Override
    public StockItem save(StockItem object) {
        return stockItemRepository.save(object);
    }

    @Override
    public void delete(StockItem object) {
        stockItemRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        stockItemRepository.deleteById(aLong);
    }

    @Override
    public Optional<StockItem> findById(Long aLong) {
        return stockItemRepository.findById(aLong);
    }
}
