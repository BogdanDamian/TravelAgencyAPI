package org.travel.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.travel.model.City;
import org.travel.model.Country;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    List<City> getAllByIsDestinationFalse(Pageable pageable);

    List<City> getAllByIsDestinationTrue(Pageable pageable);

    List<City> getAllByNameContaining(String name, Pageable pageable);

    List<City> getAllByCountry(Country country, Pageable pageable);

    List<City> getAllByCountryAndNameContaining(Country country, String name, Pageable pageable);

    List<City> getAllByCountryAndIsDestination(Country country, Boolean isDestination, Pageable pageable);
}
