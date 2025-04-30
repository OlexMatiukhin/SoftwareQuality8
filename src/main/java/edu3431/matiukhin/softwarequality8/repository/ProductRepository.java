package edu3431.matiukhin.softwarequality8.repository;/*
@author sasha
@project SoftwareQual8
@class ProductRepository
@version 1.0.0
@since 01.05.2025 - 01 - 43
*/

import edu3431.matiukhin.softwarequality8.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
}
