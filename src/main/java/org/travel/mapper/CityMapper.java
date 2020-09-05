package org.travel.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.travel.dto.CityDto;
import org.travel.model.City;

@Mapper(componentModel = "spring")
public interface CityMapper {
    @Mappings(@Mapping(source = "countryId", target = "country.id"))
    City dtoToModel(CityDto cityDto);

    @Mappings(@Mapping(source = "country.id", target = "countryId"))
    CityDto modelToDto(City city);
}
