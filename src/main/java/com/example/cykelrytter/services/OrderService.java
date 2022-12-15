package com.example.cykelrytter.services;

import com.example.cykelrytter.model.Order;
import com.example.cykelrytter.model.Product;
import com.example.cykelrytter.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService implements IOrderService{

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Set<Order> findAll() {
        Set<Order> orderSet = new HashSet<>(orderRepository.findAll());
        return orderSet;    }

    @Override
    public Order save(Order object) {
        return orderRepository.save(object);
    }

    @Override
    public void delete(Order object) {
        orderRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        orderRepository.deleteById(aLong);
    }

    @Override
    public Optional<Order> findById(Long aLong) {
        return orderRepository.findById(aLong);
    }

    @Override
    public Long findLastOrder() {
        ArrayList<Order> orderSet = new ArrayList<>(orderRepository.findAll());
        orderSet.sort(Comparator.comparing(Order :: getId).reversed());
        return orderSet.get(0).getId();
    }
}
