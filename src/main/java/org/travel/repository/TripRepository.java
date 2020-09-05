package org.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.travel.model.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip,Long> {
}
