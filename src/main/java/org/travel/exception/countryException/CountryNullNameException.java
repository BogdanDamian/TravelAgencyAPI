package org.travel.exception.countryException;

import org.travel.exception.TravelAgencyException;

public class CountryNullNameException extends TravelAgencyException {
    private static final String MESSAGE = "COUNTRY NAME CAN'T BE NULL";

    public CountryNullNameException() {
        super(MESSAGE);
    }
}
