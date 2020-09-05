package org.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoadDto {
    private Long id;
    private Long fromCityId;
    private Long toCityId;
    private Double price;
}
