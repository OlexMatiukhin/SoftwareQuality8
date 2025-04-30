package edu3431.matiukhin.softwarequality8.service;/*
@author sasha
@project SoftwareQuality5
@class ItemService
@version 1.0.0
@since 14.04.2025 - 15 - 29
*/



import edu3431.matiukhin.softwarequality8.model.Product;
import edu3431.matiukhin.softwarequality8.repository.ProductRepository;
import edu3431.matiukhin.softwarequality8.request.CreateProductRequest;
import edu3431.matiukhin.softwarequality8.request.ProductRequest;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository itemRepository;

    // Optional hardcoded items for testing
    public List<Product> items = new ArrayList();
    {
        items.add(new Product("1", "Smartphones and mobile phones", "Smartphone", "Redmi Note 5A", 3333, "00001", "Made in China."));
        items.add(new Product("2", "Furniture", "Office chair", "Art Metal Furniture A-36 black", 4444, "00002", "Just usual office chair"));
        items.add(new Product("3", "Large household appliances", "Fridges", "MPM MPM-46-CJ-01", 3333, "00003", "Refrigerator with freezer compartment"));
    }

    @PostConstruct
    public void init() {
        this.itemRepository.deleteAll();
        this.itemRepository.saveAll(this.items);
    }

    public List<ProductRequest> getAll() {
        List<Product> items = itemRepository.findAll();
        return items.stream()
                .map(this::toCreateItemRequest)
                .collect(Collectors.toList());
    }

    public ProductRequest getById(String id) {
        Product item = this.itemRepository.findById(id).orElse(null);
        return item != null ? toCreateItemRequest(item) : null;
    }

    public ProductRequest createItem(ProductRequest itemDTO) {
        Product itemFromDTO = fromDto(itemDTO);
        Product savedItem = this.itemRepository.save(itemFromDTO);
        return toCreateItemRequest(savedItem);  // Return the saved item as DTO
    }

    public ProductRequest updateItem(ProductRequest itemDTO) {
        Product itemFromDTO = fromDto(itemDTO);
        Product savedItem = this.itemRepository.save(itemFromDTO);
        return toCreateItemRequest(savedItem);  // Return the saved item as DTO
    }

    public void deleteById(String id) {
        this.itemRepository.deleteById(id);
    }

    public Product fromDto(ProductRequest dto) {
        return new Product(dto.id(), dto.category(), dto.type(), dto.name(), dto.price(), dto.code(), dto.description());
    }

    public ProductRequest toCreateItemRequest(Product item) {
        return new ProductRequest(item.getId(), item.getCategory(), item.getType(), item.getName(), item.getPrice(), item.getCode(), item.getDescription());
    }


    public Product toItemFromItemCreateRequest(CreateProductRequest createProductRequest) {

        return new Product(createProductRequest.category(), createProductRequest.type(), createProductRequest.name(), createProductRequest.price(), createProductRequest.code(), createProductRequest.description());
    }


}
