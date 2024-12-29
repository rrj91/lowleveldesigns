package com.scaler.exception;

public class NoParkingSpotFoundException extends RuntimeException {
    public NoParkingSpotFoundException(String message) {
        super(message);
    }
}
