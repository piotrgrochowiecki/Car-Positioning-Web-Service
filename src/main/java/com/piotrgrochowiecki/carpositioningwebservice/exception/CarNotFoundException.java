package com.piotrgrochowiecki.carpositioningwebservice.exception;

public class CarNotFoundException extends Exception {

    public CarNotFoundException(String uuid) {
        super("Could not find car with uuid " + uuid);
    }

}
