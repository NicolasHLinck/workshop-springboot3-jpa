package com.educandoweb.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository; 


@Service
public class OrderService {
	@Autowired
    private OrderRepository repository;

    @Transactional
    public List<Order> findAll() {
        List<Order> list = repository.findAll();
        // força inicialização de items
        list.forEach(order -> order.getItems().size());
        return list;
    }

    @Transactional
    public Order findById(Long id) {
        Order order = repository.findById(id).get();
        // força inicialização de items
        order.getItems().size();
        return order;
		
	}
}
