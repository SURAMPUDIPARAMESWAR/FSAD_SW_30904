package com.klu.repository;

import com.klu.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Derived Query Method
    List<Product> findByCategory(String category);

    // Derived Query Method
    List<Product> findByPriceBetween(double min, double max);

    // JPQL Query - Sort products by price
    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> getProductsSortedByPrice();

    // JPQL Query - Fetch expensive products
    @Query("SELECT p FROM Product p WHERE p.price > ?1")
    List<Product> getExpensiveProducts(double price);

    // JPQL Query - Fetch by category
    @Query("SELECT p FROM Product p WHERE p.category = ?1")
    List<Product> getProductsByCategory(String category);
}