package edu3431.matiukhin.softwarequality8.repository;/*
@author sasha
@project SoftwareQuality5
@class ItemRepository
@version 1.0.0
@since 14.04.2025 - 15 - 28
*/



import edu3431.matiukhin.softwarequality8.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
    @Query("{ 'code': :#{#code} }")
    Optional<Product> findByCode(@Param("code") String code);
}