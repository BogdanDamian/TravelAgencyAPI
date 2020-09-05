package org.travel.mapper;

import org.mapstruct.Mapper;
import org.travel.dto.CountryDto;
import org.travel.model.Country;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    Country dtoToModel(CountryDto countryDto);

    CountryDto modelToDto(Country country);
}
