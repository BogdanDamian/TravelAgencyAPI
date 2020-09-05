package org.travel.exception;

public class TravelAgencyException extends Exception {
    private static final String MESSAGE = "GENERIC RETAIL ERROR";

    protected TravelAgencyException() {
        super(MESSAGE);
    }

    protected TravelAgencyException(String message) {
        super(message);
    }
}
