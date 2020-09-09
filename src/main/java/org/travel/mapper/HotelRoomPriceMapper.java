package org.travel.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.travel.dto.HotelRoomPriceDto;
import org.travel.model.HotelRoomPrice;

@Mapper(componentModel = "spring")
public interface HotelRoomPriceMapper {
    @Mappings({@Mapping(source = "hotelId", target = "hotel.id"),
            @Mapping(source = "roomId", target = "room.id")})
    HotelRoomPrice dtoToModel(HotelRoomPriceDto hotelRoomPriceDto);

    @Mappings({@Mapping(source = "hotel.id", target = "hotelId"),
            @Mapping(source = "room.id", target = "roomId")})
    HotelRoomPriceDto modelToDto(HotelRoomPrice hotelRoomPrice);
}
