package org.travel.exception.countryException;

import org.travel.exception.TravelAgencyException;

public class CountryNotFoundException extends TravelAgencyException {
    private static final String MESSAGE = "COUNTRY WITH THIS ID DOES NOT EXIST";

    public CountryNotFoundException() {
        super(MESSAGE);
    }
}
