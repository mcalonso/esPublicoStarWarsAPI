package com.Espublico.StarWarsAPI.Repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Espublico.StarWarsAPI.Mapper.PeopleRowMapper;
import com.Espublico.StarWarsAPI.Models.People;

@Repository
public class PeopleRepository {

	@Autowired
	public JdbcTemplate jdbctempl = new JdbcTemplate();
	
	public void save(People people) {
		
		jdbctempl.update("INSERT INTO PEOPLE VALUES(?,?,?,?,?,?,?,?,?,?,?,?)",
				serializeID(people.getUrl()),
				people.getName(),
				people.getHeight(),
				people.getMass(),
				people.getHairColor(),
				people.getSkinColor(),
				people.getEyeColor(),
				people.getBirthYear(),
				people.getGender(),
				people.getCreated(),
				people.getEdited(),
				people.getUrl());
	}
	
	public void savePeopleXStarship(String url, String starship) {
		jdbctempl.update("INSERT INTO PEOPLE_X_STARSHIP VALUES(?,?)",
				serializeID(url),
				serializeID(starship));
	}
	
	private Integer serializeID(String id) {
		return Integer.parseInt((id.substring(id.length() - 3)).replaceAll("/", ""));
	}
	
	public List<People> findAll() {
        List<People> lpeople = jdbctempl.query("SELECT * FROM PEOPLE", new PeopleRowMapper());
        return lpeople;
		
    }
	
	public List<Map<String, Object>> findCountByFilms(){
	
		List<Map<String, Object>> lresult = jdbctempl.queryForList(" SELECT nullif(p.name, lag(p.name) over (order by null)) character, "
				+ "	 count(*) over ( partition by p.id ) contador,"
				+ "  f.title title"
				+ "  FROM people p"
				+ "  LEFT JOIN film_x_people fp"
				+ "  	ON fp.id_people = p.id"
				+ "  RIGHT JOIN film f "
				+ "        ON fp.id_film = f.id"
				+ "  ORDER BY p.name");
		
		return lresult;
	}
	
	public List<Map<String, Object>> findCountPilot(String films){
		
		List<Map<String, Object>> lresult = jdbctempl.queryForList("SELECT DISTINCT g.name character, count(*) over ( partition by g.name ) contador"
				+ "  FROM people g"
				+ "    LEFT JOIN people_x_starship a"
				+ "       ON a.id_people = g.id"
				+ "    LEFT JOIN film_x_people f"
				+ "       ON f.id_people = g.id"
				+ "  WHERE f.id_film IN ("+films+")"
				+ "  ORDER BY contador desc"
				+ "	 FETCH FIRST 1 ROWS ONLY");
		
		return lresult;
	}
	
}
