package org.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.travel.mapper.TripMapper;
import org.travel.repository.TripRepository;

@Service
public class TripService {
    @Autowired
    private TripRepository tripRep;
    @Autowired
    private TripMapper tripMap;
}
