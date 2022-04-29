package com.Espublico.StarWarsAPI.Controllers;

import java.security.KeyStore.Entry;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Espublico.StarWarsAPI.Models.People;
import com.Espublico.StarWarsAPI.Services.PeopleService;

@Controller
@RequestMapping(path = "/people")
public class PeopleController {
	
	@Autowired
	private PeopleService peopleService;
	
	@GetMapping("/")
	public String getPeople(Model model) {
		model.addAttribute("listPeople", peopleService.findAll());
		return "people";
	}
	
	@GetMapping("/getPeople")
	private ModelAndView getAPIPeople(Model model) {
		peopleService.getAPIPeople();
		model.addAttribute("listPeople", peopleService.findAll());
		return new ModelAndView("redirect:/people/", (Map<String, ?>) model);
	}
	
	@GetMapping("/summaryPeople")
	private String findCountByFilms(Model model) {
		model.addAttribute("listSummaryPeople", peopleService.findCountByFilms());
		return "summaryPeople";
	}
	
	@GetMapping("/summaryPilot")
	private String findCountPilot(Model model, @RequestParam("fieldIdList") List<String> fieldIdList) {
		List<Map<String, Object>> map = peopleService.findCountPilot(String.join(",", fieldIdList));
		model.addAttribute("listSummaryPilot", map);
		return "summaryPilot";
	}
	
	@PostMapping
	public void save(@RequestBody People people) {
		peopleService.save(people);
	}
}
