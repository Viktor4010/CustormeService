package ru.ivanov.CustomerService.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import ru.ivanov.CustomerService.exceptions.IncorrectClientInputDataException;

import java.util.List;

public class ErrorsUtil {
    public static void responseToClientForIncorrectClientInputData(BindingResult bindingResult) {
        StringBuilder errorMsg = new StringBuilder();

        List<FieldError> errors = bindingResult.getFieldErrors();
        for (FieldError error : errors) {
            errorMsg.append(error.getField())
                    .append(" - ").append(error.getDefaultMessage() == null ? error.getCode() : error.getDefaultMessage())
                    .append("; ");
        }

        throw new IncorrectClientInputDataException(errorMsg.toString());
    }
}
