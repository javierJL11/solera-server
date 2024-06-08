package com.proyectoCitas.proyectoCitas.service.impl;

import com.proyectoCitas.proyectoCitas.entity.Client;
import com.proyectoCitas.proyectoCitas.entity.Room;
import com.proyectoCitas.proyectoCitas.exception.ResourceNotFoundException;
import com.proyectoCitas.proyectoCitas.repository.ClientRepository;
import com.proyectoCitas.proyectoCitas.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Override
    public Client createClient(Client client) {
        Client saveClient;
        try {
            saveClient = clientRepository.save(client);
        }catch(Exception ResourceNotFoundException){
            throw new ResourceNotFoundException("error al agregar paciente");
        }
        return saveClient;
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> listClients;
        try {
            listClients = clientRepository.findAll();
        } catch (Exception ResourceNotFoundException) {
            throw new ResourceNotFoundException("Error al obtener lista de pacientes");
        }
        return listClients;
    }

    @Override
    public Client getClientById(Long clientId) {
        return clientRepository.findById(clientId) .orElseThrow(() ->
                new ResourceNotFoundException(("El paciente no exixte para el id : " + clientId)));
    }

    @Override
    public Client updateClient(Long clientId, Client updatedClient) {
        Client getClient = getClientById(clientId);
        if(getClient !=null){
            getClient.setOwner(updatedClient.getOwner());
            getClient.setEmail(updatedClient.getEmail());
            getClient.setPhone(updatedClient.getPhone());
            getClient.setState(updatedClient.getState());
            getClient.setType(updatedClient.getType());
            getClient.setPatientName(updatedClient.getPatientName());
            getClient.setModifiedDate(updatedClient.getModifiedDate());
        }
        Client saveClient;
        try {
            saveClient = clientRepository.save(getClient);
        } catch (Exception ResourceNotFoundException) {
            throw new ResourceNotFoundException("Error al modificar el paciente");
        }
        return saveClient;
    }

    @Override
    public void deleteClient(Long clientId) {
        try {
            clientRepository.deleteById(clientId);
        } catch (Exception ResourceNotFoundException) {
            throw new ResourceNotFoundException("Error al eliminar paciente");
        }
    }

    @Override
    public List<Client> getActiveClient() {
        List<Client> listClients;
        try {
            listClients = clientRepository.getActiveClient();
        } catch (Exception ResourceNotFoundException) {
            throw new ResourceNotFoundException("Error al obtener lista de pacientes");
        }
        return listClients;
    }
}
