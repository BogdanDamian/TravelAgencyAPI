package org.travel.exception.clientException;

import org.travel.exception.TravelAgencyException;

public class ClientsNotFoundException extends TravelAgencyException {
    private static final String MESSAGE = "LIST OF CLIENTS IS EMPTY";

    public ClientsNotFoundException() {
        super(MESSAGE);
    }
}
