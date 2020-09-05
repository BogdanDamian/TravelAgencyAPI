package org.travel.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.travel.dto.RoadDto;
import org.travel.model.Road;

@Mapper(componentModel = "spring")
public interface RoadMapper {
    @Mappings({@Mapping(source = "fromCityId", target = "from_city_id"),
            @Mapping(source = "toCityId", target = "to_city_id")})
    Road dtoToModel(RoadDto roadDto);

    @Mappings({@Mapping(source = "from_city_id", target = "fromCityId"),
            @Mapping(source = "to_city_id", target = "toCityId")})
    RoadDto modelToDto(Road road);
}
