package com.piotrgrochowiecki.carpositioningwebservice.domain.exception;

public class NotFoundRuntimeException extends RuntimeException {

    public NotFoundRuntimeException(ObjectType objectType, String id) {
        super("Could not find " + objectType + " with id " + id);
    }
}
