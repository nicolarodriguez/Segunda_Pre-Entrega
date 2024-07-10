package com.amb.shop.services;

import com.amb.shop.entities.Cart;
import com.amb.shop.entities.Invoice;
import com.amb.shop.respositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.List;
import java.util.Optional;

//Creamos el servicio del comprobante
@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ClientRepository clientRepository;

    //Creamos una invoice con el precio y la fecha de compra(purchasedate)
    public Invoice createInvoice(Long clientId){
        Cart cart = cartRepository.findByClientId(clientId);
        if (cart == null){
            throw new RuntimeException("El carrito con esa id no existe");
        }
        double total = cart.getCartItems().stream().mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity()).sum();

        Invoice invoice = new Invoice();
        invoice.setClient(clientRepository.findById(clientId).orElseThrow());
        invoice.setTotal(total);
        invoice.setPurchasedate(new Date());

        return invoiceRepository.save(invoice);
    }
    //Leemos la invoice
    public Invoice readInvoice(Long clientId){
        return invoiceRepository.findByClientId(clientId);
    }
}
