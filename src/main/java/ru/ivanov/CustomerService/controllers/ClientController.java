package ru.ivanov.CustomerService.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.ivanov.CustomerService.dto.AddressDTO;
import ru.ivanov.CustomerService.dto.ClientDTO;
import ru.ivanov.CustomerService.entities.Client;
import ru.ivanov.CustomerService.services.ClientService;

import javax.validation.Valid;

@RestController
public class ClientController {

    private final ClientService clientService;
    private final ModelMapper modelMapper;

    @Autowired
    public ClientController(ClientService clientService, ModelMapper modelMapper) {
        this.clientService = clientService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(value = "client", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDTO> retrieveClient(@RequestParam(value = "name") String name,
                                                    @RequestParam(value = "surname") String surname) {

        Client client = clientService.fetchClient(name, surname);
        ClientDTO response = convertToClientDTO(client);


        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setStreet(client.getAddress().getStreet());
        addressDTO.setStreetNumber(client.getAddress().getStreetNumber());

        response.setAddressDTO(addressDTO);


        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping(value = "client/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> register(@RequestBody @Valid ClientDTO clientDTO,
                                         BindingResult bindingResult) {

        Client client = convertToClient(clientDTO);

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        clientService.saveClientToDB(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    private Client convertToClient(ClientDTO clientDTO) {
        return modelMapper.map(clientDTO, Client.class);
    }

    private ClientDTO convertToClientDTO(Client client) {
        return modelMapper.map(client, ClientDTO.class);
    }


}
