package org.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelRoomPriceDto {
    private Long id;
    private Long hotelId;
    private Long roomId;
    private Double price;
}
