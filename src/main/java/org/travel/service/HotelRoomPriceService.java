package org.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.travel.mapper.HotelRoomPriceMapper;
import org.travel.repository.HotelRoomPriceRepository;

@Service
public class HotelRoomPriceService {
    @Autowired
    private HotelRoomPriceRepository hotelRoomPriceRep;
    @Autowired
    private HotelRoomPriceMapper hotelRoomPriceMap;
}
