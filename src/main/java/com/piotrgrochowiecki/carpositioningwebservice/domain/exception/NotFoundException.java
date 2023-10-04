package com.piotrgrochowiecki.carpositioningwebservice.domain.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String id) {
        super("Could not find object with id " + id);
    }

}
