package org.travel.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.travel.service.RoadService;

@RestController
@RequestMapping("/api/road")
public class RoadController {
    @Autowired
    private RoadService roadSrv;
}
