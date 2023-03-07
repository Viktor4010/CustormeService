package ru.ivanov.CustomerService.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ivanov.CustomerService.entities.Address;
import ru.ivanov.CustomerService.repositories.AddressRepository;

@Service
public class AddressService {
    private static final Logger log = LoggerFactory.getLogger(AddressService.class);
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Transactional
    public void updateAddress(int id, Address updatedAddress) {

        Address addressToBeUpdated = addressRepository.findById(id);

        updatedAddress.setId(id);
        updatedAddress.setClient(addressToBeUpdated.getClient());
        log.info("Update user address");
        addressRepository.save(updatedAddress);
    }
}
