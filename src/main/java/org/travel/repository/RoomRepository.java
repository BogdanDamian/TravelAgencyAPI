package org.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.travel.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
}
