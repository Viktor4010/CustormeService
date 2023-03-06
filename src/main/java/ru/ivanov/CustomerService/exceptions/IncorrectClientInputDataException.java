package ru.ivanov.CustomerService.exceptions;

public class IncorrectClientInputDataException extends RuntimeException {
    public IncorrectClientInputDataException(String message) {
        super(message);
    }
}
