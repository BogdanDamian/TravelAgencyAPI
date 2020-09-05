package org.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.travel.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
