package com.bachorz.mongodbspring.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class QueryMethodController {

//    private final ProductService service;
    private final QueryMethodService queryMethodService;

//    @PostMapping
//    public ResponseEntity<String> save(@RequestBody Product product){
//        return ResponseEntity.ok(service.save(product));
//    }

//    @GetMapping
//    public ResponseEntity<List<Product>> findAll() {
//        return ResponseEntity.ok(service.findAll());
//    }
//
//    @GetMapping("/{product-id}")
//    public ResponseEntity<Product> findById (@PathVariable("product-id") String productId) {
//        return ResponseEntity.ok(service.findById(productId));
//    }

//    @DeleteMapping("/{product-id}")
//    public ResponseEntity<Void> delete(@PathVariable("product-id") String productId) {
//        service.delete(productId);
//        return ResponseEntity.accepted().build();
//    }

    @GetMapping("/search/name")
    public ResponseEntity<List<Product>> searchByNameQ(@RequestParam("name") String name) {
        return ResponseEntity.ok(queryMethodService.searchByName(name));
    }

    @GetMapping("/search/starts-with")
    public ResponseEntity<List<Product>> searchByNameStartWithQ(@RequestParam("name") String name) {
        return ResponseEntity.ok(queryMethodService.searchByNameStartingWith(name));
    }

    @GetMapping("/search/ends-with")
    public ResponseEntity<List<Product>> searchByNameEndsWithQ(@RequestParam("name") String name) {
        return ResponseEntity.ok(queryMethodService.searchByNameEndingWith(name));
    }

    @GetMapping("/search/containing")
    public ResponseEntity<List<Product>> searchByNameContaining(@RequestParam("name") String name) {
        return ResponseEntity.ok(queryMethodService.searchByNameContaining(name));
    }

    @GetMapping("/search/lt")
    public ResponseEntity<List<Product>> searchByPriceLtQ(@RequestParam("price") BigDecimal price) {
        return ResponseEntity.ok(queryMethodService.searchByPriceLt(price));
    }

    @GetMapping("/search/gt")
    public ResponseEntity<List<Product>> searchByPriceGt(@RequestParam("price") BigDecimal price) {
        return ResponseEntity.ok(queryMethodService.searchByGt(price));
    }

    @GetMapping("/search/between")
    public ResponseEntity<List<Product>> searchByPriceBetween(@RequestParam("price1") BigDecimal price1, @RequestParam("price2") BigDecimal price2) {
        return ResponseEntity.ok(queryMethodService.searchByPriceBetween(price1, price2));
    }

    @GetMapping("/sort/asc")
    public ResponseEntity<List<Product>> sortAscByFieldQ(@RequestParam("field") String field) {
        return ResponseEntity.ok(queryMethodService.searchAndSortAsc(field));
    }

    @GetMapping("/sort/sort-page")
    public ResponseEntity<List<Product>> sortAndPageByFieldQ(@RequestParam("field") String field,
                                                             @RequestParam(value = "page-number", required = false, defaultValue = "0") int pageNumber,
                                                             @RequestParam(value = "size", required = false, defaultValue = "2") int size) {
        return ResponseEntity.ok(queryMethodService.sortAndPageByField(field, pageNumber, size));
    }
}
