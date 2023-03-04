package ru.ivanov.CustomerService.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.ivanov.CustomerService.dto.ClientDTO;

import javax.validation.Valid;

@RestController
@RequestMapping("client")
public class ClientController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDTO> retrieveClient() {
        // todo

        return null;
    }

    @PostMapping(value = "register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> register(@RequestBody @Valid ClientDTO clientDTO,
                                         BindingResult bindingResult) {
        // TODO: 04.03.2023


        return null;
    }
}
