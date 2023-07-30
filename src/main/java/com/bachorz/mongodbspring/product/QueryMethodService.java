package com.bachorz.mongodbspring.product;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryMethodService {

    @Autowired
    public ProductRepository productRepository;

    public List<Product> searchByName(String productName) {
        return productRepository.findAllByNameIgnoreCase(productName);
    }

    public List<Product> searchByNameStartingWith(String productName) {
        return productRepository.findAllByNameStartingWith(productName);
    }

    public List<Product> searchByNameEndingWith(String productName) {
        return productRepository.findAllByNameEndingWith(productName);
    }

    public List<Product> searchByNameContaining(String productName) {
        return productRepository.findAllByNameContainingIgnoreCase(productName);
    }

    public List<Product> searchByPriceLt(BigDecimal price) {
        return productRepository.findAllByPriceLessThan(price);
    }

    public List<Product> searchByPriceBetween(BigDecimal price1, BigDecimal price2){
        return productRepository.findAllByPriceBetween(price1, price2);
    }

    public List<Product> searchByGt(BigDecimal price) {
        return productRepository.findAllByPriceGreaterThan(price);
    }

    public List<Product> searchAndSortAsc(String name) {
        return productRepository.findAllByNameContainingIgnoreCaseOrderByPrice(name);
    }

    public List<Product> sortAndPageByField(String fieldName, int pageNumber, int size) {
        Pageable page = PageRequest.of(pageNumber,size);
        return productRepository.findAllByNameContainingIgnoreCaseOrderByPrice(fieldName, page);
    }
}
