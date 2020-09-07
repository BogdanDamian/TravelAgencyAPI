package org.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.travel.dto.CityDto;
import org.travel.dto.CountryDto;
import org.travel.exception.TravelAgencyException;
import org.travel.exception.cityException.CitiesNotFoundException;
import org.travel.mapper.CityMapper;
import org.travel.mapper.CountryMapper;
import org.travel.model.City;
import org.travel.repository.CityRepository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CityService {
    @Autowired
    private CityRepository cityRep;
    @Autowired
    private CountryService countrySrv;
    @Autowired
    private CityMapper cityMap;
    @Autowired
    private CountryMapper countryMap;

    private List<City> getAll(Integer pageNr, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNr, pageSize);
        return cityRep.findAll(pageable).toList();
    }

    private List<City> getAllActiveOrInactiveDestinations(Integer pageNr, Integer pageSize, String actOrIn) {
        Pageable pageable = PageRequest.of(pageNr, pageSize);
        if (actOrIn.equals("active")) return cityRep.getAllByIsDestinationTrue(pageable);
        else if (actOrIn.equals("inactive")) return cityRep.getAllByIsDestinationFalse(pageable);
        else return getAll(pageNr, pageSize);
    }

    private List<City> getAllByNameContaining(Integer pageNr, Integer pageSize, String name) {
        Pageable pageable = PageRequest.of(pageNr, pageSize);
        return cityRep.getAllByNameContaining(name, pageable);
    }

    private List<City> getAllByCountry
            (Integer pageNr, Integer pageSize, Long countryId) throws TravelAgencyException {
        CountryDto countryDto = countrySrv.getById(countryId);
        Pageable pageable = PageRequest.of(pageNr, pageSize);
        return cityRep.getAllByCountry(countryMap.dtoToModel(countryDto), pageable);
    }

    private List<City> getAllByCountryAndNameContaining
            (Integer pageNr, Integer pageSize, Long countryId, String name) throws TravelAgencyException {
        CountryDto countryDto = countrySrv.getById(countryId);
        Pageable pageable = PageRequest.of(pageNr, pageSize);
        return cityRep.getAllByCountryAndNameContaining(countryMap.dtoToModel(countryDto), name, pageable);
    }

    private List<City> getAllByCountryAndActiveOrInactiveDestination
            (Integer pageNr, Integer pageSize, Long countryId, String actOrIn) throws TravelAgencyException {
        CountryDto countryDto = countrySrv.getById(countryId);
        Pageable pageable = PageRequest.of(pageNr, pageSize);
        Boolean isDestination = actOrIn.equals("active");
        return cityRep.getAllByCountryAndIsDestination(countryMap.dtoToModel(countryDto), isDestination, pageable);
    }

    public List<CityDto> get(Integer pageNr, Integer pageSize,
                             String actOrIn, String name, Long countryId) throws TravelAgencyException {
        List<City> cities;
        if (actOrIn == null) {
            if (name == null && countryId == null) cities = getAll(pageNr, pageSize);
            else if (name == null) cities = getAllByCountry(pageNr, pageSize, countryId);
            else if (countryId == null) cities = getAllByNameContaining(pageNr, pageSize, name);
            else {
                cities = getAllByCountryAndNameContaining(pageNr, pageSize, countryId, name);
            }
        } else if (name == null) {
            if (countryId == null) cities = getAllActiveOrInactiveDestinations(pageNr, pageSize, actOrIn);
            else {
                cities = getAllByCountryAndActiveOrInactiveDestination(pageNr,pageSize,countryId,actOrIn);
            }
        } else if (countryId == null) cities = null; //todo
        else cities = null; //todo

        if (cities.size() == 0) throw new CitiesNotFoundException();

        return cities.stream()
                .map(city -> cityMap.modelToDto(city))
                .collect(Collectors.toList());


    }
}
