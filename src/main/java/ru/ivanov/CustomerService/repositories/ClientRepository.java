package ru.ivanov.CustomerService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ivanov.CustomerService.entities.Client;

import java.util.Optional;


@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByNameAndSurname(String name, String surname);

    Optional<Client> findClientByName(String name);

    Optional<Client> findClientBySurname(String surname);
}
