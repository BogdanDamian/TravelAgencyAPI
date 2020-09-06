package org.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.travel.service.RoomService;

@RestController
@RequestMapping("/api/room")
public class RoomController {
    @Autowired
    private RoomService roomSrv;
}
