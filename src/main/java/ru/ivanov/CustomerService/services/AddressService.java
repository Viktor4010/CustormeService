package ru.ivanov.CustomerService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ivanov.CustomerService.entities.Address;
import ru.ivanov.CustomerService.repositories.AddressRepository;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Transactional
    public void updateAddress(Address address, int id) {
        address.setId(id);
        addressRepository.save(address);
    }
}
