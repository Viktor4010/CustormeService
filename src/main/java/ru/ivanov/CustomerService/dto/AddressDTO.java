package ru.ivanov.CustomerService.dto;

import lombok.Getter;
import lombok.Setter;
import ru.ivanov.CustomerService.entities.Client;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AddressDTO {
    @NotEmpty(message = "Street name should not be empty")
    private String street;

    @NotNull(message = "Street number should not be empty")
    @Min(value = 1, message = "Street number should be positive and more then 1")
    private int streetNumber;


    private Client client;
}
