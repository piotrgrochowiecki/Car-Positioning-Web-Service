package com.piotrgrochowiecki.carpositioningwebservice.remote.controller;

import com.piotrgrochowiecki.carpositioningwebservice.remote.dto.NotFoundRuntimeExceptionDto;
import com.piotrgrochowiecki.carpositioningwebservice.domain.exception.NotFoundRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(NotFoundRuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public NotFoundRuntimeExceptionDto handleNotFoundException(NotFoundRuntimeException exception) {
        return NotFoundRuntimeExceptionDto.builder()
                .message(exception.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();
    }
}
