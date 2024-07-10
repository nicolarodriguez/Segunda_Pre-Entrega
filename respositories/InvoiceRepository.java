package com.amb.shop.respositories;

import com.amb.shop.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repositorio basico de invoice
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    Invoice findByClientId(Long clientId);
}
