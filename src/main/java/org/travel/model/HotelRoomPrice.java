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
public class HotelRoomPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double price;

    @ManyToOne
    @JoinColumn(name = "hotel_id", foreignKey = @ForeignKey(name = "HOTEL_HOTEL_ROOM_PRICE_FK"))
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "room_id", foreignKey = @ForeignKey(name = "ROOM_HOTEL_ROOM_PRICE_FK"))
    private Room room;

    @OneToMany(mappedBy = "hotelRoomPrice")
    private List<Trip> trips;
}
