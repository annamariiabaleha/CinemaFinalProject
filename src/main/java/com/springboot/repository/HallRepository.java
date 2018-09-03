package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Hall;

@Repository
public interface HallRepository extends JpaRepository<Hall, Integer> {
	
	@Query ("select h from Hall h where h.id = :id")
	Hall findHallById (@Param ("id") int id);

	@Query ("select id, name from Hall")
	List<Hall> findAllHalls ();
	
	@Query ("select h from Hall h where h.isAvailable = true")
	List<Hall> findAllAvailableHalls ();
	
}
