package ru.ivanov.CustomerService.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.ivanov.CustomerService.dto.AddressDTO;
import ru.ivanov.CustomerService.dto.ClientDTO;

import javax.validation.Valid;

@RestController
public class AddressController {

    @PatchMapping(value = "update/address", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateAddress(@RequestBody @Valid AddressDTO addressDTO,
                                         BindingResult bindingResult) {
        // TODO: 04.03.2023


        return null;
    }
}
