package com.elhagez.location.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.elhagez.location.entities.Location;
@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

	
	
@Query ("select type,count(type) from location1 group by type")
public List <Object[]> findTypeAndTypeCount();	
}
