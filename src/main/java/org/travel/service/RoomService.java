package org.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.travel.mapper.RoomMapper;
import org.travel.repository.RoomRepository;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRep;
    @Autowired
    private RoomMapper roomMap;
}
