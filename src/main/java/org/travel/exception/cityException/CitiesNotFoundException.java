package org.travel.exception.cityException;

import org.travel.exception.TravelAgencyException;

public class CitiesNotFoundException extends TravelAgencyException {
    private static final String MESSAGE = "LIST OF CITIES IS EMPTY";

    public CitiesNotFoundException() {
        super(MESSAGE);
    }
}
