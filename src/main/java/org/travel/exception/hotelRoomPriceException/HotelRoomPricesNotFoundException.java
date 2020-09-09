package org.travel.exception.hotelRoomPriceException;

import org.travel.exception.TravelAgencyException;

public class HotelRoomPricesNotFoundException extends TravelAgencyException {
    private static final String MESSAGE = "LIST OF HOTEL_ROOM_PRICE IS EMPTY";

    public HotelRoomPricesNotFoundException() {
        super(MESSAGE);
    }
}
