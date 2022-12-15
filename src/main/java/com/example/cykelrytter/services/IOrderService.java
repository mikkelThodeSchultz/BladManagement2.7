package com.example.cykelrytter.services;


import com.example.cykelrytter.model.Order;

public interface IOrderService extends ICrudService<Order,Long> {
    Long findLastOrder();
}
