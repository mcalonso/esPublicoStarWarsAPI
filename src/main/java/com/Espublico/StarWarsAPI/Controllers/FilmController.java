package com.Espublico.StarWarsAPI.Controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Espublico.StarWarsAPI.Models.Film;
import com.Espublico.StarWarsAPI.Services.FilmService;

@Controller
@RequestMapping(path = "/films")
public class FilmController {
	
	@Autowired
	private FilmService filmService;
	
	@GetMapping("/")
	public String getFilms(Model model) {
		model.addAttribute("listFilms", filmService.findAll());
		return "films";
	}
	
	@GetMapping("/getFilms")
	private ModelAndView getAPIFilms(Model model) {
		filmService.getAPIFilms();
		model.addAttribute("listFilms", filmService.findAll());
		return new ModelAndView("redirect:/films/", (Map<String, ?>) model);
	}
	
	@PostMapping
	public void save(@RequestBody Film film) {
		filmService.save(film);
	}
}
