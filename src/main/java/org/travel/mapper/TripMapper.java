package org.travel.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.travel.dto.TripDto;
import org.travel.model.Trip;


@Mapper(componentModel = "spring")
public interface TripMapper {
    @Mappings({@Mapping(source = "clientId", target = "client_id"),
            @Mapping(source = "roadId", target = "road_id"),
            @Mapping(source = "hotelRoomPriceId", target = "hotel_room_price_id")})
    Trip dtoToModel(TripDto tripDto);

    @Mappings({@Mapping(source = "client_id", target = "clientId"),
            @Mapping(source = "road_id", target = "roadId"),
            @Mapping(source = "hotel_room_price_id", target = "hotelRoomPriceId")})
    TripDto modelToDto(Trip trip);
}
