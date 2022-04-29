package com.Espublico.StarWarsAPI.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Espublico.StarWarsAPI.Mapper.FilmList;
import com.Espublico.StarWarsAPI.Models.Film;
import com.Espublico.StarWarsAPI.Repositories.FilmRepository;

@Service
public class FilmService {

	@Autowired
	private FilmRepository filmRepository;
	
	public void save(Film film) {
		filmRepository.save(film);
	}
	
	public void saveFilmXCharacter(String url, String character) {
		filmRepository.saveFilmXCharacter(url, character);
	}
	
	public void saveFilmXStarship(String url, String starship) {
		filmRepository.saveFilmXStarship(url, starship);
	}
	
	public List<Film> findAll() {
		return filmRepository.findAll();
	}
	
	public void getAPIFilms() {
		try {
			String url_films = "https://swapi.py4e.com/api/films/";
			RestTemplate restTemplate = new RestTemplate();
			do {
				FilmList filmList = restTemplate.getForObject(url_films, FilmList.class);
				List<Film> lfilms = filmList.getResults();
				for(Film film : lfilms) {
					save(film);
					for(String character : film.getCharacters()) {
						saveFilmXCharacter(film.getUrl(), character);
					}
					for(String starship : film.getStarships()) {
						saveFilmXStarship(film.getUrl(), starship);
					}
				}
				url_films = filmList.getNext();
			} while(url_films != null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
