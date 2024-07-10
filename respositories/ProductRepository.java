package com.amb.shop.respositories;

import com.amb.shop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repositorio basico de product
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
