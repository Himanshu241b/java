package com.example.crud.repository;

import com.example.crud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> { // interger is primary key data type of Product entity
    Product findByName(String name);
}
