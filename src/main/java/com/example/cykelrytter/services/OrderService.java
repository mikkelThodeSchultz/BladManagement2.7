package com.example.cykelrytter.services;

import com.example.cykelrytter.model.Order;
import com.example.cykelrytter.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
@Service
public class OrderService implements IOrderService{

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Set<Order> findAll() {
        return null;
    }

    @Override
    public Order save(Order object) {
        return null;
    }

    @Override
    public void delete(Order object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Order> findById(Long aLong) {
        return Optional.empty();
    }
}
