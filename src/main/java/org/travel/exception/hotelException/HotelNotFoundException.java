package org.travel.exception.hotelException;

import org.travel.exception.TravelAgencyException;

public class HotelNotFoundException extends TravelAgencyException {
    private static final String MESSAGE = "HOTEL WHIT THIS IS DOESN'T EXISTS";

    public HotelNotFoundException() {
        super(MESSAGE);
    }
}
