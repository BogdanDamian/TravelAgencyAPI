package org.travel.exception.countryException;

import org.travel.exception.TravelAgencyException;

public class CountryExistsException extends TravelAgencyException {
    public static final String MESSAGE = "COUNTRY WITH THIS ID EXISTS";

    public CountryExistsException() {
        super(MESSAGE);
    }
}
