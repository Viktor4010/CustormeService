package ru.ivanov.CustomerService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ivanov.CustomerService.entities.Client;
import ru.ivanov.CustomerService.repositories.ClientRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional(readOnly = true)
    public Optional<Client> fetchClient(String name, String surname) {
        Optional<Client> foundClient = clientRepository.findByNameAndSurname(name, surname);

        return Optional.ofNullable(foundClient.orElseThrow(IllegalArgumentException::new));
    }

    @Transactional
    public void saveClientToDB(Client client) {
        enrichClient(client);
        clientRepository.save(client);
    }

    private void enrichClient(Client client) {
        client.setRegisterAt(LocalDateTime.now());
    }


}
