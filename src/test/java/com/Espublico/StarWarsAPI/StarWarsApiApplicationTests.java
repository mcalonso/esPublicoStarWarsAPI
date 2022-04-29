package com.Espublico.StarWarsAPI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Espublico.StarWarsAPI.Repositories.FilmRepository;
import com.Espublico.StarWarsAPI.Repositories.PeopleRepository;
import com.Espublico.StarWarsAPI.Services.FilmService;
import com.Espublico.StarWarsAPI.Services.PeopleService;
import com.Espublico.StarWarsAPI.Services.StarshipService;

@SpringBootTest
class StarWarsApiApplicationTests {

	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private PeopleRepository peopleRepository;
	@Autowired
	private FilmService filmservice;
	@Autowired
	private PeopleService peopleService;
	@Autowired
	private StarshipService starshipService;
	
	@Test
	void findAllFilms() {
		try {
			filmRepository.findAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void findCountByFilms() {
		try {
			peopleRepository.findCountByFilms();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void getAPIFilms() {
		try {
			filmservice.getAPIFilms();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void getAPIPeople() {
		try {
			peopleService.findCountPilot("3,4");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void getAPIStarships() {
		try {
			starshipService.getAPIStarships();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
