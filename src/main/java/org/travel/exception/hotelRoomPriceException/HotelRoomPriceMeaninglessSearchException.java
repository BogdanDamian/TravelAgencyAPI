package org.travel.exception.hotelRoomPriceException;

import org.travel.exception.TravelAgencyException;

public class HotelRoomPriceMeaninglessSearchException extends TravelAgencyException {
    private static final String MESSAGE = "THERE IS NO REASON TO SEARCH BY HOTEL AND ROOM";

    public HotelRoomPriceMeaninglessSearchException() {
        super(MESSAGE);
    }
}
