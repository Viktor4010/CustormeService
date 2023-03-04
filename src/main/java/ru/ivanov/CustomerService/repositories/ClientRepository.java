package ru.ivanov.CustomerService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ivanov.CustomerService.entities.Client;



@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByNameAndSurname(String name, String surname);
}
