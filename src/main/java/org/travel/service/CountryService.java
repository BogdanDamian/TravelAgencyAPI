package org.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.travel.dto.CountryDto;
import org.travel.exception.TravelAgencyException;
import org.travel.exception.countryException.*;
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

    private CountryDto saveOrUpdate(CountryDto countryDto) throws TravelAgencyException {
        if (countryDto.getName() == null) throw new CountryNullNameException();
        if (countryDto.getCode() == null) throw new CountryNullCodeException();
        if (countryDto.getNeedVisa() == null) throw new CountryNullNeedVisaException();
        Country country = countryMap.dtoToModel(countryDto);
        country = countryRep.save(country);
        return countryMap.modelToDto(country);
    }

    public CountryDto save(CountryDto countryDto) throws TravelAgencyException {
        if (countryDto.getId() != null && countryRep.existsById(countryDto.getId()))
            throw new CountryExistsException();
        return saveOrUpdate(countryDto);
    }

    public CountryDto update(CountryDto countryDto) throws TravelAgencyException {
        if (!countryRep.existsById(countryDto.getId())) throw new CountryNotFoundException();
        return saveOrUpdate(countryDto);
    }

    public CountryDto deleteById(Long id) throws TravelAgencyException {
        CountryDto countryDto = getById(id);
        countryRep.delete(countryMap.dtoToModel(countryDto));
        return countryDto;
    }


}
