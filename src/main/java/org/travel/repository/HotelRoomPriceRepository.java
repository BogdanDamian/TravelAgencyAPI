package org.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.travel.model.Hotel;
import org.travel.model.HotelRoomPrice;
import org.travel.model.Room;

import java.util.List;

@Repository
public interface HotelRoomPriceRepository extends JpaRepository<HotelRoomPrice, Long> {

    List<HotelRoomPrice> findAllByHotel(Hotel hotel);

    List<HotelRoomPrice> findAllByRoom(Room room);
}
