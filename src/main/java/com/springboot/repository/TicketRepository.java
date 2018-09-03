package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	
	@Query ("select t from Ticket t inner join t.session s "
			+ "where s.id = :sessionId")// and t.isApproved = false ")
//			+ "and TIME(t.creationTime + '0:05:00') <= TIME(NOW())")
	List<Ticket> findTemporaryTickets(@Param ("sessionId") int sessionId);

}
