package com.Espublico.StarWarsAPI.Repositories;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Espublico.StarWarsAPI.Mapper.FilmRowMapper;
import com.Espublico.StarWarsAPI.Models.Film;

@Repository
public class FilmRepository { 
	
	@Autowired
	public JdbcTemplate jdbctempl = new JdbcTemplate();

	public void save(Film film) {

		jdbctempl.update("INSERT INTO FILM VALUES(?,?,?,?,?,?,?,?,?,?)",
				serializeID(film.getUrl()),
				film.getTitle(),
				film.getEpisodeId(),
				film.getOpeningCrawl(),
				film.getDirector(),
				film.getProducer(),
				film.getReleaseDate(),
				film.getCreated(),
				film.getEdited(),
				film.getUrl());
	}
	
	public void saveFilmXCharacter(String url, String character) {
		jdbctempl.update("INSERT INTO FILM_X_PEOPLE VALUES(?,?)",
				serializeID(url),
				serializeID(character));
	}
	
	public void saveFilmXStarship(String url, String starship) {
		jdbctempl.update("INSERT INTO FILM_X_STARSHIP VALUES(?,?)",
				serializeID(url),
				serializeID(starship));
	}
	
	private Integer serializeID(String id) {
		return Integer.parseInt((id.substring(id.length() - 3)).replaceAll("/", ""));
	}
	
	public List<Film> findAll() {
        List<Film> lfilms = jdbctempl.query("SELECT * FROM FILM ORDER BY EPISODE", new FilmRowMapper());
        return lfilms;
		
    }
}
