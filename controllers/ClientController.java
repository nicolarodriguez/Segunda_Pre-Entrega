package com.amb.shop.controllers;

import com.amb.shop.entities.Client;
import com.amb.shop.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
public class ClientController {
    @Autowired private ClientService clientService;

    //Definimos la ruta /register que pide la consigna para crear un cliente
    @PostMapping("/register")
    public Client createClient(@RequestBody Client client){
        return clientService.createClient(client);
    }

    //Esta funcion muestra todos los clientes
    @GetMapping
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    //Con esto podemos obtener un cliente por su id
    @GetMapping("/{id}")
    public Optional<Client> getClientById(@PathVariable Long id){
        return clientService.modifyClient(id, new Client());
    }
    //Con esto modificamos el cliente y usamos la ruta que pide la consigna
    @PutMapping("/me/{id}")
    public ResponseEntity<?> modifyClient(@PathVariable Long id, @RequestBody Client client){
        Optional<Client> modifiedClient = clientService.modifyClient(id, client);
                return ResponseEntity.ok(modifiedClient);
    }

    //Y con este metodo podemos borrar un cliente a partir de su id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClientById(@PathVariable Long id){
        try{
            clientService.deleteClientById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}