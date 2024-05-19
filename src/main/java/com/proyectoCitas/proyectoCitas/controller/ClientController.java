package com.proyectoCitas.proyectoCitas.controller;

import com.proyectoCitas.proyectoCitas.entity.Client;
import com.proyectoCitas.proyectoCitas.entity.Employee;
import com.proyectoCitas.proyectoCitas.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(path="/api/client", method = RequestMethod.POST)
    public ResponseEntity<Client> createClient (@RequestBody Client client){
        Client saveClient =  clientService.createClient(client);
        return new ResponseEntity<>(saveClient, HttpStatus.CREATED);
    }

    @RequestMapping (path="/api/client/{id}", method = RequestMethod.GET)
    public ResponseEntity<Client> getClientById(@PathVariable("id") Long clientId){
        Client client =  clientService.getClientById(clientId);
        return ResponseEntity.ok(client);
    }

    @RequestMapping (path="/api/client", method = RequestMethod.GET)
    public ResponseEntity<List<Client>> getAllClients(){
        List<Client> clients =  clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @RequestMapping (path="/api/client/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Client> updateClient(@PathVariable("id") Long clientId, @RequestBody Client updatedClient){
        Client client= clientService.updateClient(clientId,updatedClient);
        return ResponseEntity.ok(client);
    }

    @RequestMapping (path="/api/client/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteClient (@PathVariable("id") Long clientId){
        clientService.deleteClient(clientId);
        return ResponseEntity.ok("Consultorio eliminado exitosamente!");

    }
}
