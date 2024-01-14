package com.example.marketplace.dao;

import com.example.marketplace.object.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketplaceRepository extends JpaRepository<Product,Integer> {
}
