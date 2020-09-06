package org.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.travel.mapper.RoadMapper;
import org.travel.repository.RoadRepository;

@Service
public class RoadService {
    @Autowired
    private RoadRepository roadRep;
    @Autowired
    private RoadMapper roadMap;
}
