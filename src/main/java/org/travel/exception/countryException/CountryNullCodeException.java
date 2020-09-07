package org.travel.exception.countryException;

import org.travel.exception.TravelAgencyException;

public class CountryNullCodeException extends TravelAgencyException {
    private static final String MESSAGE = "COUNTRY CODE CAN'T BE NULL";

    public CountryNullCodeException() {
        super(MESSAGE);
    }
}
