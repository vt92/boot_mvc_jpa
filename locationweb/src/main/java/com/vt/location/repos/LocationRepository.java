package com.vt.location.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vt.location.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

	//in HQL we use entity class name, not table name
	@Query("select type,count(type) from Location group by type")
	public List<Object[]> findTypeAndTypeCount();
}
