package com.amb.shop.controllers;

import com.amb.shop.entities.Product;
import com.amb.shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    //Aca creamos el producto
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
    //aca podemos ver todos los productos creados
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    //aca podemos ver productos por id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    //aca podemos modificar productos por su id
    @PutMapping("/{id}")
    public Optional<Product> modifyProduct(@PathVariable Long id, @RequestBody Product productDetails){
            return productService.modifyProduct(id, productDetails);
    }
    //aca podemos borrar productos por su id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id){
        try{
            productService.deleteProductById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

}
