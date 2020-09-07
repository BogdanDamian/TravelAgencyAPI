package org.travel.exception.clientException;

import org.travel.exception.TravelAgencyException;

public class ClientExistsException extends TravelAgencyException {
    public static final String MESSAGE = "CLIENT WITH THIS ID EXISTS";

    public ClientExistsException() {
        super(MESSAGE);
    }
}
