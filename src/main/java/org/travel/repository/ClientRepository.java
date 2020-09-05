package org.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.travel.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
