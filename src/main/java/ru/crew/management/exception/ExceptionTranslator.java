package ru.crew.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionTranslator {


    @ExceptionHandler(ApiException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ServiceError processApiException(ApiException apiException) {
        return new ServiceError(apiException.getMessage());

    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ServiceError processIllegalStateException(IllegalStateException apiException) {
        return new ServiceError(apiException.getMessage());
    }
}
