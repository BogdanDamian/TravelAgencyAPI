package org.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.travel.service.TripService;

@RestController
@RequestMapping("/api/trip")
public class TripController {
    @Autowired
    private TripService tripSrv;
}
