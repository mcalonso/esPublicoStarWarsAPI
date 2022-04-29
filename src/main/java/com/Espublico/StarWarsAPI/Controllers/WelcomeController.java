package com.Espublico.StarWarsAPI.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Espublico.StarWarsAPI.Services.WelcomeService;


@Controller
public class WelcomeController {
	
	@Autowired
	private WelcomeService welcomeService;

    @GetMapping("/")
    public String main(Model model) {
    	model.addAttribute("countFilms", welcomeService.getCountFilm());
    	model.addAttribute("countPeople", welcomeService.getCountPeople());
    	model.addAttribute("countStarships", welcomeService.getCountStarship());
        return "welcome";
    }
}