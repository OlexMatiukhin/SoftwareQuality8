package edu3431.matiukhin.softwarequality8.controller;/*
@author sasha
@project SoftwareQuality7
@class ProductRestController
@version 1.0.0
@since 24.04.2025 - 20 - 21
*/


import edu3431.matiukhin.softwarequality8.request.ProductRequest;
import edu3431.matiukhin.softwarequality8.service.ProductService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequiredArgsConstructor
@RequestMapping({"/api/v1/products"})
public class ProductRestController {
    private final ProductService itemService;

    @GetMapping
    public List<ProductRequest> getAllItems() {
        return this.itemService.getAll();
    }

    @GetMapping({"/{id}"})
    public ProductRequest getItemById(@PathVariable String id) {
        return this.itemService.getById(id);
    }

    @PostMapping
    public ProductRequest createItem(@RequestBody ProductRequest item) {
        return this.itemService.createItem(item);
    }

    @PutMapping
    public ProductRequest updateItem(@RequestBody ProductRequest item) {
        return this.itemService.updateItem(item);
    }

    @DeleteMapping({"/{id}"})
    public void deleteItem(@PathVariable String id) {
        this.itemService.deleteById(id);
    }


}
