package org.travel.exception.roomException;

import org.travel.exception.TravelAgencyException;

public class RoomNotFoundException extends TravelAgencyException {
    private static final String MESSAGE = "ROOM WHIT THIS IS DOESN'T EXISTS";

    public RoomNotFoundException() {
        super(MESSAGE);
    }
}
