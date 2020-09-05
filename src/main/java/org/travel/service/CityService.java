package org.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.travel.dto.CityDto;
import org.travel.mapper.CityMapper;
import org.travel.repository.CityRepository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CityService {
    @Autowired
    private CityRepository cityRep;
    @Autowired
    private CityMapper cityMap;

    public List<CityDto> getAll(Integer pageNr, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNr,pageSize);
        return cityRep.findAll(pageable).stream()
                .map(city -> cityMap.modelToDto(city))
                .collect(Collectors.toList());
    }
}
