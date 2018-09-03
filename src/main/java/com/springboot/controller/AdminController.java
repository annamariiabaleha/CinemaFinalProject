package com.springboot.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.domain.ImageRequest;
import com.springboot.domain.MovieWrapper;
import com.springboot.entity.Hall;
import com.springboot.entity.Movie;
import com.springboot.entity.Session;
import com.springboot.entity.UserEntity;
import com.springboot.mapper.UserMapper;
import com.springboot.repository.HallRepository;
import com.springboot.service.HallService;
import com.springboot.service.MovieService;
import com.springboot.service.SessionService;
import com.springboot.service.UserService;
import com.springboot.service.utils.CustomFileUtils;

import javax.swing.JOptionPane;


@Controller
@RequestMapping ("/admin")
@SessionAttributes("hallSelect")
public class AdminController {
	
	
	private UserService userService;
	private MovieService movieService;
	private HallService hallService;
	private SessionService sessionService;
	
	@Autowired
	public AdminController(UserService userService, MovieService movieService, HallService hallService,
			SessionService sessionService) {
		this.userService = userService;
		this.movieService = movieService;
		this.hallService = hallService;
		this.sessionService = sessionService;
	}

	@GetMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String showAdminPage	(Model model, Principal principal) throws IOException {
			UserEntity user = userService.findUserByEmail(principal.getName());
			
		//	user.setImagePath(CustomFileUtils.getImage("user_" + user.getId(), user.getImagePath()));
			model.addAttribute("adminProfile", UserMapper.entityToUserProfile(user));
			return "admin/profile";
	}

	@GetMapping ("/add-movie")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String showAddMoviePage (Model model) {
		model.addAttribute("uploadModel", new MovieWrapper());
		return "admin/add-movie";
	}
	
	@PostMapping ("/add-movie")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String saveMovie (  @Valid @ModelAttribute ("uploadModel") MovieWrapper movieWrapper,
			BindingResult result ) throws IOException { 
		if (result.hasErrors()) {
			return "redirect:/admin";
		
		}
		System.out.println(movieWrapper.getMovie().getName());
		movieService.saveMovie(movieWrapper.movie);
		movieWrapper.getMovie().setImagePath("movie_" + movieWrapper.getMovie().getId() + ".png");
		
		CustomFileUtils.createImage("movies_folder", movieWrapper.getMovie().getImagePath(), movieWrapper.getFile());
		movieService.saveMovie(movieWrapper.getMovie());
		return "redirect:/admin/movies-list";
	}
	
	@GetMapping ("/add-hall")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String showAddHallPg (Model model) {
		HashMap<Boolean, String> hallSelect = new HashMap<>();
		hallSelect.put(true, "Ready");
		hallSelect.put(false, "On hold");
		
		model.addAttribute("hallSelect", hallSelect);
		model.addAttribute("addHallModel", new Hall());
		return "admin/add-hall";
	}
	
	@PostMapping ("/add-hall")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String saveHall ( @Valid @ModelAttribute ("addHallModel")  Hall hall,
			BindingResult result) { 
		if (result.hasErrors()) {
			return "admin/add-hall";
		}
		hallService.saveHall(hall);
		return "redirect:/admin/halls-list";
	}
	
	@GetMapping ("/add-session")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String showSession(Model model) {
		List<Hall> hallList = hallService.findAllAvailableHalls();
		LinkedHashMap<String, String> hallSelectOptions = new LinkedHashMap<>();
		for (Hall hall : hallList) {
			hallSelectOptions.put(String.valueOf(hall.getId()), hall.getName());
		}
		
		List<Movie> movieList = movieService.findAllMovies();
		HashMap<String, String> movieSelectOption = new HashMap<>();
		for (Movie movie : movieList) {
			movieSelectOption.put(String.valueOf(movie.getId()), movie.getName());
		}
		
		
		
		model.addAttribute("movieSelectOption", movieSelectOption);
		model.addAttribute("hallSelectOptions", hallSelectOptions);
		model.addAttribute("addSessionModel", new Session());
		return "admin/add-session";
	}
	
	@PostMapping ("/add-session")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String saveSession ( @ModelAttribute ("addSessionModel") @Valid Session session,
			BindingResult result) { 
		if (result.hasErrors()) {
			return "admin/add-session";
		}
		
		String freeSeats = "";
		for (int i = 0; i < session.getHall().getCapacity(); i++) {
			freeSeats += "f";
		}
		
		session.setSeats(freeSeats);
		sessionService.saveSession(session);
		return "redirect:/admin";
	}
	
	@GetMapping ("/movies-list")
	public String showMoviesList (Model model) {
		
		model.addAttribute("moviesListModel", movieService.findAllMovies());
		return "admin/movies-list";
	}
	
	@GetMapping ("{movieId}/edit-movie")
	public String editMovie (@PathVariable ("movieId") int movieId, Model model) {
		model.addAttribute("editMovie", movieService.findMovieById(movieId));
		return "admin/edit-movie";
	}
	
	@PostMapping ("{movieId}/edit-movie")
	public String saveEditedMovie (@ModelAttribute ("editMovie") Movie movie) {
		movieService.saveMovie(movie);
		return "redirect:/admin/movies-list";
		
	}
	@GetMapping ("{movieId}/delete-movie")
	public String deleteMovie (@PathVariable ("movieId") int movieId, Model model) {
		movieService.deleteMovieById(movieId);
		return "redirect:/admin/movies-list";
		
	}
	
	@GetMapping ("{movieId}/movie")
	public String getMoviePage (@PathVariable ("movieId") int movieId, Model model) {
		model.addAttribute("movie", movieService.findMovieById(movieId));
		return "admin/movie";
		
	}
	
	@GetMapping("{hallId}/edit-hall")
	public String editHall(@PathVariable ("hallId") int halId, Model model) {
		HashMap<Boolean, String> hallSelect = new HashMap<>();
		hallSelect.put(true, "Ready");
		hallSelect.put(false, "On hold");
		
		model.addAttribute("hallSelect", hallSelect);
		model.addAttribute("editHall", hallService.findHallById(halId));
		return "admin/edit-hall";
		
	}
	
	@PostMapping ("{hallId}/edit-hall")
	public String saveEditedHall (@ModelAttribute ("editHall") Hall hall) {
		hallService.saveHall(hall);
		return "redirect:/admin/halls-list";
	}
	
	@GetMapping ("/halls-list")
	public String getHallsList (Model model) {
		model.addAttribute("hallsList", hallService.findAllHalls());
		return "admin/halls-list" ;
	}
	
	@GetMapping ("{hallId}/hall")
	public String getMovie (Model model, @PathVariable ("hallId") int hallId) {
		model.addAttribute("hall", hallService.findHallById(hallId));
		return "admin/hall";
		
	}

	@GetMapping ("/session-list")
	public String getSessionsByMovie (Model model) {
		
		List<Movie> movies = movieService.findAllMovies();
		
		HashMap<String, List<Session>> sessionList = new HashMap<>();
		for (Movie movie : movies) {
			List<Session> sessions = sessionService.findAllSessionsByMovieId(movie.getId());
			sessionList.put(movie.getName(), sessions );
		}
		
		model.addAttribute("sessionList", sessionList);
		
		
//		List<Movie> allMoviesList = movieService.findAllMovies();
//		for (Movie movie : allMoviesList) {
//			int movieId = movie.getId();
//			model.addAttribute("sessionList", sessionService.findAllSessionsByMovieId(movieId));
//		}
		
		return "admin/session-list";
		
	}
	
	@GetMapping ("{sessionId}/edit-session")
	public String editSession (@PathVariable ("sessionId") int sessionId, Model model) {
		
		List<Hall> hallList = hallService.findAllAvailableHalls();
		LinkedHashMap<String, String> hallSelectOptions = new LinkedHashMap<>();
		for (Hall hall : hallList) {
			hallSelectOptions.put(String.valueOf(hall.getId()), hall.getName());
		}
		model.addAttribute("hallSelectOptions", hallSelectOptions);
		model.addAttribute("editSession", sessionService.findSessionById(sessionId) );
		return "admin/edit-session";
	}
	
	@PostMapping ("{sessionId}/edit-session")
	public String saveEditedSession (@ModelAttribute ("editSession") Session session) {
		sessionService.saveSession(session);
		return "redirect:/admin/session-list";
	}
	
	@GetMapping ("{sessionId}/delete-session")
	public String deleteSession (@PathVariable ("sessionId") int sessionId, Model model) {
		sessionService.deleteSessionById(sessionId);
		return "redirect:/admin/session-list";
	}
	
}

