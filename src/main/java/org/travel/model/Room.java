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
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Integer singleBeds;
    private Integer doubleBeds;

    @OneToMany(mappedBy = "room")
    private List<HotelRoomPrice> hotelRoomPriceList;
}
