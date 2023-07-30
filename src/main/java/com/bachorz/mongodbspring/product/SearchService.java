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
public class SearchService {

    @Autowired
    public MongoTemplate mongoTemplate;

    public List<Product> searchByName(String productName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(productName));
        List<Product> products = mongoTemplate.find(query, Product.class);
        return products;
    }

    public List<Product> searchByNameStartingWith(String productName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex("^" + productName));
        List<Product> products = mongoTemplate.find(query, Product.class);
        return products;
    }

    public List<Product> searchByNameEndingWith(String productName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex(productName + "$"));
        List<Product> products = mongoTemplate.find(query, Product.class);
        return products;
    }

    public List<Product> searchByPriceLt(BigDecimal price) {
        Query query = new Query();
        query.addCriteria(Criteria.where("price").lt(price));
        List<Product> products = mongoTemplate.find(query, Product.class);
        return products;
    }

    public List<Product> sortAscByField(String fieldName) {
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.ASC, fieldName));
        List<Product> products = mongoTemplate.find(query, Product.class);
        return products;
    }

    public List<Product> sortAndPageByField(String fieldName) {
        Query query = new Query();
        Pageable pageable = PageRequest.of(0, 2, Sort.by(Sort.Direction.ASC, fieldName));
        query.with(pageable);
        List<Product> products = mongoTemplate.find(query, Product.class);
        return products;
    }
}
