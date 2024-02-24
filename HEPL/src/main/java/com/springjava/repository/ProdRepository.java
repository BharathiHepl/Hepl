package com.springjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springjava.model.Product;

public interface ProdRepository extends JpaRepository<Product, Integer> {

}
