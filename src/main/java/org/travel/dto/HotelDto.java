package org.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {
    private Long id;
    private Long cityId;
    private String name;
    private Integer standard;
    private String description;
}
