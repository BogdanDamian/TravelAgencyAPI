package org.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.travel.dto.HotelRoomPriceDto;
import org.travel.exception.TravelAgencyException;
import org.travel.service.HotelRoomPriceService;

import java.util.List;

@RestController
@RequestMapping("/api/hotel-room-price")
public class HotelRoomPriceController {
    @Autowired
    private HotelRoomPriceService hotelRoomPriceSrv;

    @GetMapping
    public ResponseEntity<List<HotelRoomPriceDto>> get(@RequestParam(required = false, defaultValue = "0") Integer pageNr,
                                                       @RequestParam(required = false, defaultValue = "25") Integer pageSize,
                                                       @RequestParam(required = false) Long hotelId,
                                                       @RequestParam(required = false) Long roomId) {
        try {
            return new ResponseEntity<>(hotelRoomPriceSrv.get(pageNr, pageSize, hotelId, roomId), HttpStatus.OK);
        } catch (TravelAgencyException trAgEx) {
            trAgEx.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
}
