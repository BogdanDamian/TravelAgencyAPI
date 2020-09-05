package org.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.travel.model.Road;

@Repository
public interface RoadRepository extends JpaRepository<Road,Long> {
}
