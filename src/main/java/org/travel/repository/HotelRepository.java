package org.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.travel.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
