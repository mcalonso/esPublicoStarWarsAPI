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

import com.Espublico.StarWarsAPI.Models.Starship;
import com.Espublico.StarWarsAPI.Services.StarshipService;

@Controller
@RequestMapping(path = "/starships")
public class StarshipController {

	@Autowired
	private StarshipService starshipService;
	
	@GetMapping("/")
	public String getStarships(Model model) {
		model.addAttribute("listStarships", starshipService.findAll());
		return "starships";
	}
	
	@GetMapping("/getStarships")
	private ModelAndView getAPIStarships(Model model) {
		starshipService.getAPIStarships();
		model.addAttribute("listStarships", starshipService.findAll());
		return new ModelAndView("redirect:/starships/", (Map<String, ?>) model);
	}
	
	@PostMapping
	public void save(@RequestBody Starship starship) {
		starshipService.save(starship);
	}
}
