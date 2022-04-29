package com.Espublico.StarWarsAPI.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Espublico.StarWarsAPI.Models.People;

public class PeopleRowMapper implements RowMapper<People> {

	@Override
	public People mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		People character = new People();
		character.setId(rs.getInt("ID"));
		character.setName(rs.getString("NAME"));
		character.setHeight(rs.getString("HEIGHT"));
		character.setMass(rs.getString("MASS"));
		character.setHairColor(rs.getString("HAIR_COLOR"));
		character.setSkinColor(rs.getString("SKIN_COLOR"));
		character.setEyeColor(rs.getString("EYE_COLOR"));
		character.setBirthYear(rs.getString("BIRTH_YEAR"));
		character.setGender(rs.getString("GENDER"));
		character.setCreated(rs.getDate("CREATED"));
		character.setEdited(rs.getDate("EDITED"));
		character.setUrl(rs.getString("URL"));
		
		return character;
	}
}
