package com.example.cykelrytter.services;

import com.example.cykelrytter.model.Product;
import com.example.cykelrytter.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
@Service
public class ProductService implements IProductService{

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Set<Product> findAll() {
        return null;
    }

    @Override
    public Product save(Product object) {
        return null;
    }

    @Override
    public void delete(Product object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Product> findById(Long aLong) {
        return Optional.empty();
    }
}
