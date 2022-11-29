package com.example.cykelrytter.repositories;

import com.example.cykelrytter.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,Long> {
}
