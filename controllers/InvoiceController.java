package com.amb.shop.controllers;

import com.amb.shop.entities.Invoice;
import com.amb.shop.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    //Con este metodo creamos una invoice
    @PostMapping("/{clientId}")
    public ResponseEntity<Invoice> createInvoice(@PathVariable Long clientId){
        Invoice invoice = invoiceService.createInvoice(clientId);
        return ResponseEntity.ok(invoice);
    }
    //Con esto obtenemos una invoice a partir de la id
    @GetMapping("/{clientId}")
    public ResponseEntity<Invoice> readInvoice(@PathVariable Long clientId){
        Invoice invoice = invoiceService.readInvoice(clientId);
        return ResponseEntity.ok(invoice);
    }
}
