package org.travel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer persons;
    private LocalDate fromDate;
    private LocalDate toDate;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "client_id", foreignKey = @ForeignKey(name = "CLIENT_TRIP_FK"))
    private Client client;

    @ManyToOne
    @JoinColumn(name = "hotel_room_price_id", foreignKey = @ForeignKey(name = "HOTEL_ROOM_PRICE_TRIP_FK"))
    private HotelRoomPrice hotelRoomPrice;

    @ManyToOne
    @JoinColumn(name = "road_id", foreignKey = @ForeignKey(name = "ROAD_TRIP_FK"))
    private Road road;
}
