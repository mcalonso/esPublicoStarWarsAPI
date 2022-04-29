package com.Espublico.StarWarsAPI.Repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Espublico.StarWarsAPI.Mapper.StarshipRowMapper;
import com.Espublico.StarWarsAPI.Models.Starship;


@Repository
public class StarshipRepository {

	@Autowired
	public JdbcTemplate jdbctempl = new JdbcTemplate();
	
	public void save(Starship starship) {
		
		jdbctempl.update("INSERT INTO STARSHIP VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
				serializeID(starship.getUrl()),
				starship.getName(),
				starship.getModel(),
				starship.getManufacturer(),
				starship.getCostInCredits(),
				starship.getLength(),
				starship.getMaxAtmospheringSpeed(),
				starship.getCrew(),
				starship.getPassengers(),
				starship.getCargoCapacity(),
				starship.getConsumables(),
				starship.getHyperdriveRating(),
				starship.getMglt(),
				starship.getStarshipClass(),
				starship.getCreated(),
				starship.getEdited(),
				starship.getUrl());
	}
	
	private Integer serializeID(String id) {
		return Integer.parseInt((id.substring(id.length() - 3)).replaceAll("/", ""));
	}
	
	public List<Starship> findAll() {
        List<Starship> lstarship = jdbctempl.query("SELECT * FROM STARSHIP", new StarshipRowMapper());
        return lstarship;
		
    }
}
