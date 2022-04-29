package com.Espublico.StarWarsAPI.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class WelcomeRepository {

	@Autowired
	public JdbcTemplate jdbctempl = new JdbcTemplate();
	
	public boolean getCountFilm() {
		boolean checkFilms = true; 
			if(jdbctempl.queryForObject("SELECT count(*) numFilms FROM FILM", Integer.class) > 0) {
				checkFilms = false;
			}
        return checkFilms; 
	}
	
	public boolean getCountPeople() {
		boolean checkPeople = true; 
			if(jdbctempl.queryForObject("SELECT count(*) numPeople FROM PEOPLE", Integer.class) > 0) {
				checkPeople = false;
			}
        return checkPeople; 
	}
	
	public boolean getCountStarship() {
		boolean checkStarships = true; 
			if(jdbctempl.queryForObject("SELECT count(*) numFilms FROM STARSHIP", Integer.class) > 0) {
				checkStarships = false;
			}
	    return checkStarships; 
	}
}
