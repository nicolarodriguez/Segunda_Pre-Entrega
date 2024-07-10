package com.amb.shop.services;

import com.amb.shop.entities.Product;
import com.amb.shop.respositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Creamos el servicio para los productos
@Service
public class ProductService {

    @Autowired private ProductRepository productRepository;

    //Funcion para crear productos
    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    //Esto muestra una lista con todos los productos
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    //Si hay un producto con esa id que le pasamos lo muestra si no, devuelve null
    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }
    //Esto guarda al product
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
    //Esto elimina un producto a partir de la id
    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }
    //Con optional podemos verificar si hay o no un producto con esa id y modificarlo
    public Optional<Product> modifyProduct(Long id, Product productDetails){
        return productRepository.findById(id).map(product-> {
            product.setName(productDetails.getName());
            product.setPrice(productDetails.getPrice());
            return productRepository.save(product);
        });
    }
}
