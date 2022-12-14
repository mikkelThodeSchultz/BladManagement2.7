package com.example.cykelrytter.repositories;

import com.example.cykelrytter.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine,Long> {
}
