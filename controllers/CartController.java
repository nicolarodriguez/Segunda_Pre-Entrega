package com.amb.shop.controllers;

import com.amb.shop.entities.Cart;
import com.amb.shop.entities.Client;
import com.amb.shop.respositories.ClientRepository;
import com.amb.shop.services.CartService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private ClientRepository clientRepository;

    //Con esta funcion podemos ver el carrito del usuario a partir de su id
    @GetMapping("/{clientId}")
    public ResponseEntity<Cart> getAllFromCart(@PathVariable Long clientId){
        Cart cart = cartService.getCartById(clientId);
        return ResponseEntity.ok(cart);
    }
    //Con esta funcion agregamos un producto y la cantidad al carrito
    @PostMapping("/{clientId}")
    public ResponseEntity<Cart> addToCart(@PathVariable Long clientId, @RequestBody ProductRequest request){
        Cart cart = cartService.addProductToCart(clientId, request.getProductId(), request.getQuantity());
        return ResponseEntity.ok(cart);
    }
    //Con esta funcion sacamos el producto y la cantidad de este del carrito
    @DeleteMapping("/{clientId}")
    public ResponseEntity<Cart> removeFromCart(@PathVariable Long clientId, @RequestBody ProductRequest request){
        Cart cart = cartService.removeFromCart(clientId, request.getProductId(), request.getQuantity());
        return ResponseEntity.ok(cart);
    }
    //Metodo static para optimizar el carrito
    public static class ProductRequest {
        private Long productId;
        private int quantity;

        public Long getProductId() {
            return productId;
        }
        public void setProductId(Long productId) {
            this.productId = productId;
        }
        public int getQuantity() {
            return quantity;
        }
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
