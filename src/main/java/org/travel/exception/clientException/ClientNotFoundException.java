package org.travel.exception.clientException;

import org.travel.exception.TravelAgencyException;

public class ClientNotFoundException extends TravelAgencyException {
    private static final String MESSAGE = "CLIENT WHIT THIS IS DOESN'T EXISTS";

    public ClientNotFoundException() {
        super(MESSAGE);
    }
}
