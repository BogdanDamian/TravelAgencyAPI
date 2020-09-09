package org.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.travel.dto.HotelDto;
import org.travel.dto.RoomDto;
import org.travel.exception.TravelAgencyException;
import org.travel.exception.hotelException.HotelNotFoundException;
import org.travel.exception.roomException.RoomNotFoundException;
import org.travel.mapper.RoomMapper;
import org.travel.model.Hotel;
import org.travel.model.Room;
import org.travel.repository.RoomRepository;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRep;
    @Autowired
    private RoomMapper roomMap;

    public RoomDto getById(Long id) throws TravelAgencyException {
        Room room = roomRep.findById(id).orElse(null);
        if (room == null) throw new RoomNotFoundException();
        return roomMap.modelToDto(room);
    }
}
