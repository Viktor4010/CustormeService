package ru.ivanov.CustomerService.exceptions;

public class IncorrectInputDataException extends RuntimeException {
    public IncorrectInputDataException(String message) {
        super(message);
    }
}
