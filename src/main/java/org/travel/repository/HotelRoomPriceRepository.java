package org.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.travel.model.HotelRoomPrice;

@Repository
public interface HotelRoomPriceRepository extends JpaRepository<HotelRoomPrice, Long> {
}
