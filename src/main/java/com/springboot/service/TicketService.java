package com.springboot.service;

import java.util.List;

import com.springboot.entity.Ticket;

public interface TicketService {

	void saveTicket (Ticket ticket);
	
	void deleteTicket(Ticket ticket);
	
	List<Ticket> findTemporaryTickets (int sessionId);
	
	List<Ticket> findAll ();
	
	Ticket findById (int ticketId);
}
