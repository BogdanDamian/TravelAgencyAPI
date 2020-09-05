package org.travel.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.travel.dto.TripDto;
import org.travel.model.Trip;


@Mapper(componentModel = "spring")
public interface TripMapper {
    @Mappings({@Mapping(source = "clientId", target = "client.id"),
            @Mapping(source = "roadId", target = "road.id"),
            @Mapping(source = "hotelRoomPriceId", target = "hotelRoomPrice.id")})
    Trip dtoToModel(TripDto tripDto);

    @Mappings({@Mapping(source = "client.id", target = "clientId"),
            @Mapping(source = "road.id", target = "roadId"),
            @Mapping(source = "hotelRoomPrice.id", target = "hotelRoomPriceId")})
    TripDto modelToDto(Trip trip);
}
