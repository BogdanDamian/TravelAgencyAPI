package org.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryDto {
    private Long id;
    private String code;
    private String name;
    private Boolean needVisa;
}
