package ru.ivanov.CustomerService.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.ivanov.CustomerService.dto.AddressDTO;
import ru.ivanov.CustomerService.entities.Address;
import ru.ivanov.CustomerService.services.AddressService;
import ru.ivanov.CustomerService.util.ErrorsUtil;


import javax.validation.Valid;

@RestController
public class AddressController {

    private final AddressService addressService;
    private final ModelMapper modelMapper;

    @Autowired
    public AddressController(AddressService addressService, ModelMapper modelMapper) {
        this.addressService = addressService;
        this.modelMapper = modelMapper;
    }

    @PatchMapping(value = "update/address/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateAddress(@RequestBody @Valid AddressDTO addressDTO,
                                              BindingResult bindingResult, @PathVariable("id") int id) {
        Address address = convertToAddress(addressDTO);

        if (bindingResult.hasErrors())
            ErrorsUtil.responseToClientForIncorrectClientInputData(bindingResult);

        addressService.updateAddress(id, address);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    private Address convertToAddress(AddressDTO addressDTO) {
        return modelMapper.map(addressDTO, Address.class);
    }
}
