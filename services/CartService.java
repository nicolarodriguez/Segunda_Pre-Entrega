package com.amb.shop.services;

import com.amb.shop.entities.Cart;
import com.amb.shop.entities.CartItems;
import com.amb.shop.entities.Client;
import com.amb.shop.entities.Product;
import com.amb.shop.respositories.CartRepository;
import com.amb.shop.respositories.ClientRepository;
import com.amb.shop.respositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ClientRepository clientRepository;

    public Cart getCartById(Long clientId) {
        return cartRepository.findByClientId(clientId);
    }
    //Funcion para agregar productos al carrito y crear el carrito al agregar un producto
    public Cart addProductToCart(Long clientId, Long productId, int quantity) {
        Cart cart = cartRepository.findByClientId(clientId);
        if (cart == null){
            cart = new Cart();
            cart.setClient(clientRepository.findById(clientId).orElseThrow());
            cartRepository.save(cart);
        }

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + productId));

        Optional<CartItems> existingItem = cart.getCartItems().stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst();

        if (existingItem.isPresent()) {
            CartItems item = existingItem.get();
            item.setQuantity(item.getQuantity() + quantity);
        } else {
            CartItems item = new CartItems();
            item.setProduct(product);
            item.setQuantity(quantity);
            cart.getCartItems().add(item);
        }

        return cartRepository.save(cart);
    }
    //Con esta funcion sacamos un producto del carrito
    public Cart removeFromCart(Long clientId, Long productId, Integer quantity){
        Cart cart = cartRepository.findByClientId(clientId);
        if (cart != null){
            cart.getCartItems().removeIf(item -> item.getProduct().getId().equals(productId) && item.getQuantity() == quantity);
            return cartRepository.save(cart);
        }
        return null;
    }
    //Aca creamos una invoice del carrito
    public double createInvoice(Long clientId){
        Cart cart = cartRepository.findByClientId(clientId);
        return cart.getCartItems().stream().mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity()).sum();
    }
}
