package org.travel.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.travel.dto.RoadDto;
import org.travel.model.Road;

@Mapper(componentModel = "spring")
public interface RoadMapper {
    @Mappings({@Mapping(source = "fromCityId", target = "fromCity.id"),
            @Mapping(source = "toCityId", target = "toCity.id")})
    Road dtoToModel(RoadDto roadDto);

    @Mappings({@Mapping(source = "fromCity.id", target = "fromCityId"),
            @Mapping(source = "toCity.id", target = "toCityId")})
    RoadDto modelToDto(Road road);
}
