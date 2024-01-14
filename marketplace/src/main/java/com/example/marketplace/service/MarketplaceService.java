package com.example.marketplace.service;

import com.example.marketplace.dao.MarketplaceRepository;
import com.example.marketplace.object.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarketplaceService {

    private MarketplaceRepository marketplaceRepository;

    @Autowired
    public MarketplaceService(MarketplaceRepository marketplaceRepository){
        this.marketplaceRepository=marketplaceRepository;
    }

    public List<Product> findAll() {
        return marketplaceRepository.findAll();
    }

    public Product findById(int theId) {
        Optional<Product> result = marketplaceRepository.findById(theId);

        Product theProduct = null;

        if (result.isPresent()) {
            theProduct = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find product id - " + theId);
        }

        return theProduct;
    }

    public void save(Product theProduct) {
        marketplaceRepository.save(theProduct);
    }

    public void deleteById(int theId) {marketplaceRepository.deleteById(theId);
    }
}
