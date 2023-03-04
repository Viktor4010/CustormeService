package ru.ivanov.CustomerService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ivanov.CustomerService.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findById(int id);
}
