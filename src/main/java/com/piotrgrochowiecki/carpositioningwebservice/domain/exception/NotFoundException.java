package com.piotrgrochowiecki.carpositioningwebservice.domain.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String objectType, String id) {
        super("Could not find " + objectType + " with id " + id);
    }

}
