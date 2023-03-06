package ru.ivanov.CustomerService.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.ivanov.CustomerService.entities.Client;
import ru.ivanov.CustomerService.services.ClientService;

@Component
public class CustomerValidator implements Validator {
    private final ClientService clientService;

    public CustomerValidator(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Client.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Client client = (Client) target;

        if (clientService.fetchClientByHisName(client.getName()).isPresent())
            errors.rejectValue("name","Client with such name already exist");

        if (clientService.fetchClientByHisSurname(client.getSurname()).isPresent())
            errors.rejectValue("surname","Client with such surname already exist");
    }
}
