package org.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.travel.dto.CountryDto;
import org.travel.exception.TravelAgencyException;
import org.travel.exception.countryException.CountryNotFoundException;
import org.travel.mapper.CountryMapper;
import org.travel.model.Country;
import org.travel.repository.CountryRepository;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRep;
    @Autowired
    private CountryMapper countryMap;

    public CountryDto getById(Long id) throws TravelAgencyException {
        Country country = countryRep.findById(id).orElse(null);
        if (country == null) throw new CountryNotFoundException();
        return countryMap.modelToDto(country);
    }

}
