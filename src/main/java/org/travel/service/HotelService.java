package org.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.travel.mapper.HotelMapper;
import org.travel.repository.HotelRepository;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRep;
    @Autowired
    private HotelMapper hotelMap;
}
