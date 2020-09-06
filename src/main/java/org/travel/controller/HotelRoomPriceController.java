package org.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.travel.service.HotelRoomPriceService;

@RestController
@RequestMapping("/api/hotel-room-price")
public class HotelRoomPriceController {
    @Autowired
    private HotelRoomPriceService hotelRoomPriceSrv;
}
