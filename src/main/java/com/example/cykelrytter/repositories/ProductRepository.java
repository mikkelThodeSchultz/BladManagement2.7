package com.example.cykelrytter.repositories;

import com.example.cykelrytter.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
