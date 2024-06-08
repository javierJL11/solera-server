package com.proyectoCitas.proyectoCitas.service;

import com.proyectoCitas.proyectoCitas.entity.Client;

import java.util.List;

public interface ClientService {
    Client createClient(Client client);
    List<Client> getAllClients ();
    Client getClientById (Long clientId);
    Client updateClient (Long clientId, Client updatedClient);
    void deleteClient (Long clientId);
    List<Client> getActiveClient();
}
