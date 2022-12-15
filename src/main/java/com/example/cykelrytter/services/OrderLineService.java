package com.example.cykelrytter.services;

import com.example.cykelrytter.model.OrderLine;
import com.example.cykelrytter.repositories.OrderLineRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderLineService implements IOrderLineService {
    private OrderLineRepository orderLineRepository;

    public OrderLineService(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }

    @Override
    public Set<OrderLine> findAll() {
        Set<OrderLine> orderLineSet = new HashSet<>(orderLineRepository.findAll());
        return orderLineSet;
    }

    @Override
    public OrderLine save(OrderLine object) {
        return orderLineRepository.save(object);
    }

    @Override
    public void delete(OrderLine object) {
        orderLineRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        orderLineRepository.deleteById(aLong);
    }

    @Override
    public Optional<OrderLine> findById(Long aLong) {
        return orderLineRepository.findById(aLong);
    }
}
