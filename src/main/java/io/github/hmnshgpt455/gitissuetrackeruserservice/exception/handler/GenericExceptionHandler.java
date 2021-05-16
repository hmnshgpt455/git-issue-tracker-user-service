package io.github.hmnshgpt455.gitissuetrackeruserservice.exception.handler;

import io.github.hmnshgpt455.gitissuetrackeruserservice.exception.definitions.InvalidRequest;
import io.github.hmnshgpt455.gitissuetrackeruserservice.exception.errors.GenericError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.OffsetDateTime;
import java.util.UUID;

@ControllerAdvice
public class GenericExceptionHandler {

    private static final String INVALID_REQUEST = "INVALID_REQUEST";

    @ExceptionHandler(InvalidRequest.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<GenericError> handleInvalidRequest(InvalidRequest exception) {
        GenericError error = GenericError.builder()
                .message(exception.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .timestamp(OffsetDateTime.now())
                .build();

        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("error-UUID", UUID.randomUUID().toString());
        headers.add("error-code", INVALID_REQUEST);

        return new ResponseEntity<>(error, headers, HttpStatus.BAD_REQUEST);
    }
}
