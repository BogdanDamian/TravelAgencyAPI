package org.travel.mapper;

import org.mapstruct.Mapper;
import org.travel.dto.RoomDto;
import org.travel.model.Room;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    Room dtoToModel(RoomDto roomDto);

    RoomDto modelToDto(Room room);
}
