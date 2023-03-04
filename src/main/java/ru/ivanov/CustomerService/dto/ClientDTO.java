package ru.ivanov.CustomerService.dto;

import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class ClientDTO {
    @NotEmpty(message = "name should not be empty")
    private String name;

    @NotEmpty(message = "surname should not be empty")
    private String surname;

    @NotEmpty(message = "profession should not be empty")
    private String profession;

    private AddressDTO addressDTO;


}
