package ru.ivanov.CustomerService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ivanov.CustomerService.entities.Client;
import ru.ivanov.CustomerService.repositories.ClientRepository;

import java.time.LocalDateTime;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional(readOnly = true)
    public Client fetchClient(String name, String surname) {
           return clientRepository.findByNameAndSurname(name,surname);
    }

    @Transactional
    public void saveClientToDB(Client client) {
        client.getAddress().setClient(client);
        enrichClient(client);
        clientRepository.save(client);
    }

    private void enrichClient(Client client) {
        client.setRegisterAt(LocalDateTime.now());
    }


}
