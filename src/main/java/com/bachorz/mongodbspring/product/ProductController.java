package com.bachorz.mongodbspring.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;
    private final SearchService searchService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Product product){
        return ResponseEntity.ok(service.save(product));
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<Product> findById (@PathVariable("product-id") String productId) {
        return ResponseEntity.ok(service.findById(productId));
    }

    @DeleteMapping("/{product-id}")
    public ResponseEntity<Void> delete(@PathVariable("product-id") String productId) {
        service.delete(productId);
        return ResponseEntity.accepted().build();
    }

//    @GetMapping("/search/is")
//    public ResponseEntity<List<Product>> searchByName(@RequestParam("name") String name) {
//        return ResponseEntity.ok(searchService.searchByName(name));
//    }
//
//    @GetMapping("/search/starts-with")
//    public ResponseEntity<List<Product>> searchByNameStartWith(@RequestParam("name") String name) {
//        return ResponseEntity.ok(searchService.searchByNameStartingWith(name));
//    }
//
//    @GetMapping("/search/ends-with")
//    public ResponseEntity<List<Product>> searchByNameEndsWith(@RequestParam("name") String name) {
//        return ResponseEntity.ok(searchService.searchByNameEndingWith(name));
//    }
//
//    @GetMapping("/search/lt")
//    public ResponseEntity<List<Product>> searchByPriceLt(@RequestParam("price") BigDecimal price) {
//        return ResponseEntity.ok(searchService.searchByPriceLt(price));
//    }
//
//    @GetMapping("/sort/asc")
//    public ResponseEntity<List<Product>> sortAscByField(@RequestParam("field") String field) {
//        return ResponseEntity.ok(searchService.sortAscByField(field));
//    }
//
//    @GetMapping("/sort/sort-page")
//    public ResponseEntity<List<Product>> sortAndPageByField(@RequestParam("field") String field) {
//        return ResponseEntity.ok(searchService.sortAndPageByField(field));
//    }
}
