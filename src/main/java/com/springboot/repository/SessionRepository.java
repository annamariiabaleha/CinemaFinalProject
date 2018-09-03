package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Session;

@Repository		
public interface SessionRepository extends JpaRepository<Session, Integer> {

	@Query ("select s from Session s inner join s.movie m "
			+ "where m.id = :movieId")
	List<Session> findAllSessionsByMovieId (@Param ("movieId") int movieId);

	@Query ("select s from Session s inner join s.movie m "
			+ "where m.id = :movieId and (s.date = DATE(NOW()) AND TIME(s.time) >= TIME(NOW()) "
			+ "or s.date > DATE(NOW())) order by s.time")
	List<Session> findAllSessionsByMovieIdFromNow (@Param ("movieId") int movieId);
	
//	@Query ("select s from Session s where s.date = :date")
//	List<Session> findSessionsByDate (@Param ("date") String date);
	
//	@Query ("select s from Session s where s.movie = :movieId")
//	List<Session> findAllSessionsByMovieId (@Param ("movieId") int movieId);
}
