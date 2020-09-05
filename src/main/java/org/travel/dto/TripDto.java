package org.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripDto {
    private Long id;
    private Long clientId;
    private Long roadId;
    private Long hotelRoomPriceId;
    private Integer persons;
    private LocalDate fromDate;
    private LocalDate toDate;
    private Double price;
}
