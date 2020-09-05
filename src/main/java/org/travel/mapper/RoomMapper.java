package org.travel.mapper;

import org.mapstruct.Mapper;
import org.travel.dto.RoadDto;
import org.travel.model.Road;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    Road dtoToModel(RoadDto roadDto);

    RoadDto modelToModel(Road road);
}
