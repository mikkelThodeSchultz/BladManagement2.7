package com.example.cykelrytter.repositories;

import com.example.cykelrytter.model.StockItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockItemRepository extends JpaRepository<StockItem,Long> {
}
