package com.vt.location.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vt.location.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
