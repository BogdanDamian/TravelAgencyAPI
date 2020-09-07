package org.travel.exception.clientException;

import org.travel.exception.TravelAgencyException;

public class ClientNullNameException extends TravelAgencyException {
    private static final String MESSAGE = "CLIENT NAME CAN'T BE NULL";

    public ClientNullNameException() {
        super(MESSAGE);
    }
}
