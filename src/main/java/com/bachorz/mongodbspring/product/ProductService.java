package com.bachorz.mongodbspring.product;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public String save(Product product){

        return repository.save(product).toString();
    }

    public Product findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public List<Product> findAll(){
        return repository.findAll();
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
