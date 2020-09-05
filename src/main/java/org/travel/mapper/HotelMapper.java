package org.travel.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.travel.dto.HotelDto;
import org.travel.model.Hotel;

@Mapper(componentModel = "spring")
public interface HotelMapper {
    @Mappings(@Mapping(source = "cityId", target = "city.id"))
    Hotel dtoToModel(HotelDto hotelDto);

    @Mappings(@Mapping(source = "city.id", target = "cityId"))
    HotelDto modelToDto(Hotel hotel);
}
