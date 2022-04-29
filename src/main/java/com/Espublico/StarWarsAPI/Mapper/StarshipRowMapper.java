package com.Espublico.StarWarsAPI.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Espublico.StarWarsAPI.Models.Starship;

public class StarshipRowMapper implements RowMapper<Starship> {

	@Override
	public Starship mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Starship starship = new Starship();
		starship.setId(rs.getInt("ID"));
		starship.setName(rs.getString("NAME"));
		starship.setModel(rs.getString("MODEL"));
		starship.setManufacturer(rs.getString("MANUFACTURER"));
		starship.setCostInCredits(rs.getString("COST_IN_CREDITS"));
		starship.setLength(rs.getString("LENGTH"));
		starship.setMaxAtmospheringSpeed(rs.getString("MAX_ATMOSPHERING_SPEED"));
		starship.setCrew(rs.getString("CREW"));
		starship.setPassengers(rs.getString("PASSENGERS"));
		starship.setCargoCapacity(rs.getString("CARGO_CAPACITY"));
		starship.setConsumables(rs.getString("CONSUMABLES"));
		starship.setHyperdriveRating(rs.getString("HYPERDRIVE_RATING"));
		starship.setMglt(rs.getString("MGLT"));
		starship.setStarshipClass(rs.getString("STARSHIP_CLASS"));
		starship.setCreated(rs.getDate("CREATED"));
		starship.setEdited(rs.getDate("EDITED"));
		starship.setUrl(rs.getString("URL"));
		
		return starship;
	}
}
