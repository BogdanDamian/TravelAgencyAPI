package org.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.travel.dto.HotelDto;
import org.travel.exception.TravelAgencyException;
import org.travel.exception.hotelException.HotelNotFoundException;
import org.travel.mapper.HotelMapper;
import org.travel.model.Hotel;
import org.travel.repository.HotelRepository;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRep;
    @Autowired
    private HotelMapper hotelMap;

    public HotelDto getById(Long id) throws TravelAgencyException {
        Hotel hotel = hotelRep.findById(id).orElse(null);
        if (hotel == null) throw new HotelNotFoundException();
        return hotelMap.modelToDto(hotel);
    }
}
