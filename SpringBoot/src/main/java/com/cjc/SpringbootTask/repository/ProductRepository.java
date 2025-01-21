package com.cjc.SpringbootTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjc.SpringbootTask.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
