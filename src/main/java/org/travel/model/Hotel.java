package org.travel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Integer standard;
    private String description;

    @ManyToOne
    @JoinColumn(name = "city_id", foreignKey = @ForeignKey(name = "CITY_HOTEL_FK"))
    private City city;

    @OneToMany(mappedBy = "hotel")
    private List<HotelRoomPrice> hotelRoomPriceList;
}
