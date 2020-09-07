package org.travel.exception.clientException;

import org.travel.exception.TravelAgencyException;

public class ClientMeaninglessSearchException extends TravelAgencyException {
    private static final String MESSAGE = "THERE IS NO REASON TO SEARCH BY PHONE AND NAME";

    public ClientMeaninglessSearchException() {
        super(MESSAGE);
    }
}
