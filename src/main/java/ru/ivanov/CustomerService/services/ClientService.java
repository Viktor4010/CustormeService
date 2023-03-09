package ru.ivanov.CustomerService.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ivanov.CustomerService.entities.Client;
import ru.ivanov.CustomerService.repositories.ClientRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
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

    public List<Client> findAll()  {
        log.info("retrieve client's names");
       return clientRepository.findAll();
    }

    @Transactional
    public void saveClientToDB(Client client) {
        client.getAddress().setClient(client);
        enrichClient(client);
        log.info("Register new client");
        clientRepository.save(client);
    }

    public Optional<Client> fetchClientByHisName(String name) {
        return clientRepository.findClientByName(name);
    }

    public Optional<Client> fetchClientByHisSurname(String surname) {
        return clientRepository.findClientBySurname(surname);
    }

    private void enrichClient(Client client) {
        client.setRegisterAt(LocalDateTime.now());
    }


}
