package org.travel.exception.countryException;

import org.travel.exception.TravelAgencyException;

public class CountryNullNeedVisaException extends TravelAgencyException {
    private static final String MESSAGE = "COUNTRY NEED_VISA CAN'T BE NULL";

    public CountryNullNeedVisaException() {
        super(MESSAGE);
    }
}
