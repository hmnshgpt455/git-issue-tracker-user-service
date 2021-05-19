package io.github.hmnshgpt455.gitissuetrackeruserservice.exception.handler;

import io.github.hmnshgpt455.gitissuetrackeruserservice.exception.errors.BaseError;
import io.github.hmnshgpt455.gitissuetrackeruserservice.exception.errors.MethodArgumentNotValidError;
import io.github.hmnshgpt455.gitissuetrackeruserservice.exception.logger.ErrorLogger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.Collections;

@ControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class MethodArgumentNotValidExceptionHandler {

    private static final String BAD_REQUEST = "BAD_REQUEST";
    private final ErrorLogger eLogger;
    private final ErrorHandlerHelper errorHandlerHelper;

    @SuppressWarnings({"ConstantConditions", "DuplicatedCode"})
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<MethodArgumentNotValidError> handle(MethodArgumentNotValidException exception, WebRequest request) {

        BaseError baseError = errorHandlerHelper.buildErrorObject(MethodArgumentNotValidError.builder(), BAD_REQUEST,
                HttpStatus.BAD_REQUEST.value(), ((ServletWebRequest)request).getRequest().getRequestURI(),
                exception.getFieldError().getDefaultMessage());

        MethodArgumentNotValidError error = (MethodArgumentNotValidError) baseError;
        error.setFieldNames(new ArrayList<>(Collections.singleton(exception.getFieldError().getField())));

        MultiValueMap<String, String> httpHeaders = errorHandlerHelper.getHttpHeadersMap(BAD_REQUEST);

        eLogger.log(error, ((ServletWebRequest)request).getRequest().getRequestURI(), exception, httpHeaders);

        return new ResponseEntity<>(error, httpHeaders, HttpStatus.BAD_REQUEST);
    }

}
