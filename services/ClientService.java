package com.amb.shop.services;


import com.amb.shop.entities.Client;
import com.amb.shop.respositories.ClientRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

//Creamos el servicio de cliente para gestionar los clientes
@Service
public class ClientService {

    @Autowired private ClientRepository clientRepository;
    //Con esta funcion podemos crear clientes
    public Client createClient(Client client){
        return clientRepository.save(client);
    }
    //Esto muestra una lista con todos los clientes
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }
    //Si hay un cliente con esa id que le pasamos lo muestra si no, devuelve null
    public Optional<Client> getClientById(Long id){
        return clientRepository.findById(id);
    }
    //Esto guarda al cliente
    public Client saveClient(Client client){
        return clientRepository.save(client);
    }
    //Esto elimina un cliente a partir de la id
    public void deleteClientById(Long id){
        clientRepository.deleteById(id);
    }
    //Con optional podemos verificar si hay o no un cliente con esa id y modificarlo
    public Optional<Client> modifyClient(Long id, Client clientDetails){
            return clientRepository.findById(id).map(client-> {
            client.setName(clientDetails.getName());
            client.setLastname(clientDetails.getLastname());
            client.setAge(clientDetails.getAge());
            client.setDni(clientDetails.getDni());
            return clientRepository.save(client);
        });
    }

}
