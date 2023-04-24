package com.example.utnfinaljava.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.utnfinaljava.entities.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
