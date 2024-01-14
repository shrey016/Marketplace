package com.example.marketplace.controller;

import com.example.marketplace.object.Product;
import com.example.marketplace.service.MarketplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MarketplaceController {
    private MarketplaceService marketplaceService;

    @Autowired
    public MarketplaceController(MarketplaceService marketplaceService){
        this.marketplaceService=marketplaceService;
    }

    @GetMapping("/list")
    public String listProducts(Model theModel) {
        List<Product> productList=marketplaceService.findAll();
        // add to the spring model
        theModel.addAttribute("products", productList);

        return "list-products";
    }

    @GetMapping("/buyProduct")
    public String buyProduct(@RequestParam("productId") int id){
        marketplaceService.deleteById(id);
        return "productBuy-confirm";

    }


    @GetMapping("/showForm")
    public String showForm(Model model){
        Product product=new Product();
        model.addAttribute("products",product);

        return "productForm";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("products") Product product){
        marketplaceService.save(product);
        return "redirect:" +
                "/list";

    }




}
