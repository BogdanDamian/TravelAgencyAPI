package org.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.travel.service.HotelService;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelSrv;
}
