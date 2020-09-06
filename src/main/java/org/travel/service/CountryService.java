package org.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.travel.mapper.CountryMapper;
import org.travel.repository.CountryRepository;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRep;
    @Autowired
    private CountryMapper countryMap;

}
