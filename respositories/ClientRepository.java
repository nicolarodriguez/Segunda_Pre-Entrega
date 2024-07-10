package com.amb.shop.respositories;

import com.amb.shop.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repositorio basico de cliente
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
