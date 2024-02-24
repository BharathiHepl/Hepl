package com.springjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springjava.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
