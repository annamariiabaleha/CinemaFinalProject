package com.springboot.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.domain.RegisterRequest;
import com.springboot.entity.Movie;
import com.springboot.entity.Session;
import com.springboot.entity.Ticket;
import com.springboot.mapper.UserMapper;
import com.springboot.repository.TicketRepository;
import com.springboot.service.HallService;
import com.springboot.service.MovieService;
import com.springboot.service.SessionService;
import com.springboot.service.TicketService;
import com.springboot.service.UserService;
import com.springboot.service.utils.CustomFileUtils;

@Controller
public class BaseController {
	
	private UserService userService;
	private MovieService movieService;
	private SessionService sessionService;
	private HallService hallService;
	private TicketService ticketService;
	
	@Autowired
	public BaseController(UserService userService, MovieService movieService, SessionService sessionService,
			HallService hallService, TicketService ticketService) {
		this.userService = userService;
		this.movieService = movieService;
		this.sessionService = sessionService;
		this.hallService = hallService;
		this.ticketService = ticketService;
	}

	@GetMapping({"/", "/home"})
	public String showHome(Model model) throws IOException {
		List<Movie> moviesList = movieService.findAllMovies();
		for(Movie movie : moviesList) {
			movie.setImagePath(CustomFileUtils.getImage("movies_folder", movie.getImagePath()));
		}
		model.addAttribute("moviesList", moviesList);
		return "home";
	}
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
		
	@GetMapping ("/register")
	public String showRegistrationPage(Model model) {
		model.addAttribute("userModel", new RegisterRequest());
		return "register";
	}

	@PostMapping ("/register")
	public String saveUser (
			@Valid @ModelAttribute ("userModel") RegisterRequest request, BindingResult result
			) {
		
		if (result.hasErrors()) {
			return "/register";
		}
		
		userService.saveUser(UserMapper.registerToEntity(request));
		return "redirect:/user/profile";
				
	}
	
	@GetMapping ("{movieId}/movie-details")
	public String getMoviePage (@PathVariable ("movieId") int movieId, Model model) throws IOException {
		Movie movie = movieService.findMovieById(movieId);
		movie.setImagePath(CustomFileUtils.getImage("movies_folder", movie.getImagePath()));
		
		List<Session> sessions = sessionService.findAllSessionsByMovieIdFromNow(movieId);
		
		Map<Date, String> dateConvertion = new HashMap<>();
		for(Session session : sessions) {
			if (!dateConvertion.containsKey(session.getDate())) {
				Calendar date = new GregorianCalendar();
				date.setTime(session.getDate());
				String dayOfWeek = date.getDisplayName( Calendar.DAY_OF_WEEK ,Calendar.LONG, Locale.US);
				dateConvertion.put(session.getDate(), dayOfWeek + " (" + session.getDate() + ")");
			}
		}
		Map<String, List<Session>> sessionsByDate = new HashMap<>();
		
		for (Session session : sessions) {
			if (sessionsByDate.containsKey(dateConvertion.get(session.getDate()))) {
				sessionsByDate.get(dateConvertion.get(session.getDate())).add(session);
			} else {
				List<Session> newSessionList = new ArrayList<>();
				newSessionList.add(session);
				sessionsByDate.put(dateConvertion.get(session.getDate()), newSessionList);				
			}
		}
		
		model.addAttribute("movie", movie);
		model.addAttribute("sessionsByDate", sessionsByDate);
		return "movie-details";
		
	}

	@GetMapping ("{sessionId}/seats-selection")
	public String getSeatsSelectionPage (@PathVariable ("sessionId") int sessionId, Model model) {
		Session session = sessionService.findSessionById(sessionId);
		List<Ticket> ticketsToDelete = ticketService.findAll();
		System.out.println("null?:" + ticketsToDelete);
		if (ticketsToDelete != null) {
			System.out.println("Length:" + ticketsToDelete.size());
			StringBuilder seats = new StringBuilder(session.getSeats());
			for (Ticket ticket : ticketsToDelete) {
				if (
					ticket.getSession().getId() == session.getId() &&
					ticket.isApproved() == false &&
					new Timestamp(ticket.getCreationTime().getTime() + TimeUnit.MINUTES.toMillis(5)).before(new Timestamp(System.currentTimeMillis()))
				) {
					int index = (ticket.getRow() - 1) * session.getHall().getSeatsInRow() + (ticket.getSeat() - 1);
					seats.setCharAt(index, 'f');
					ticketService.deleteTicket(ticket);
				}
			}
			session.setSeats(String.valueOf(seats));
		}
		
		Map<String, String> seatsMap = new LinkedHashMap<>();
		
		for (int i = 0; i < session.getHall().getCapacity() / session.getHall().getSeatsInRow(); i++) {
			for (int j = 0; j < session.getHall().getSeatsInRow(); j++ ) {
				int index = i*session.getHall().getSeatsInRow() + j;
				if (session.getSeats().charAt(index) == 'f') {
					seatsMap.put(String.valueOf(index), "Row " + (i + 1) + " seat " + (j + 1) );
				}
			}
		}
		
		Ticket ticket = new Ticket();
		ticket.setSession(session);
		
		model.addAttribute("seatsMap", seatsMap);
		model.addAttribute("ticket", ticket);
		return "seats-selection";
	}
	
	@PostMapping ("{sessionId}/seats-selection")
	public String postSeats (@ModelAttribute ("ticket") Ticket ticket, BindingResult result ) {
		Session session = ticket.getSession();
		int index = ticket.getRow();
		StringBuilder refreshedSeats = new StringBuilder (session.getSeats());
		refreshedSeats.setCharAt(index, 't');
		session.setSeats(String.valueOf(refreshedSeats));
		
		ticket.setRow(index / session.getHall().getSeatsInRow() + 1);
		ticket.setSeat(index % session.getHall().getSeatsInRow() + 1);
		ticket.setApproved(false);
		ticket.setCreationTime(new Timestamp(System.currentTimeMillis()));
		
		sessionService.saveSession(session);
		ticketService.saveTicket(ticket);
		return "redirect:/"+ticket.getId()+"/ticket-submit";
		
	}
	
	@GetMapping ("{ticketId}/ticket-submit")
	public String getTicketSubmit (@PathVariable ("ticketId") int ticketId, Model model) {
		
		Ticket ticket = ticketService.findById(ticketId);
		model.addAttribute("ticket", ticketService.findById(ticketId));
		
		System.out.println("Ticket id" + ticket.getId());
		System.out.println("Row " + ticket.getRow());
		return "/ticket-submit";
	}
	/* update isApproved, creationTime, session.seats
	@PostMapping ("/ticket-submit")
	public String postTicketSubmit (Model model, ) {
		
	} */

	/* update isApproved, creationTime, session.seats */
	@PostMapping ("{ticketId}/ticket-submit")
	public String postTicketSubmit (@ModelAttribute ("ticket") Ticket ticket, BindingResult result ) {

		ticket.setApproved(true);
		ticket.setCreationTime(new Timestamp(System.currentTimeMillis()));
		Session session = sessionService.findSessionById(ticket.getSession().getId());
		StringBuilder seats = new StringBuilder(session.getSeats());
		int index = (ticket.getRow() - 1) * session.getHall().getSeatsInRow() + (ticket.getSeat() - 1);
		seats.setCharAt(index, 'b');
		session.setSeats(String.valueOf(seats));
		ticket.setSession(session);
		sessionService.saveSession(session);
		ticketService.saveTicket(ticket);
		return "redirect:/"+ticket.getSession().getMovie().getId()+"/movie-details";
}
	
	
	
}
