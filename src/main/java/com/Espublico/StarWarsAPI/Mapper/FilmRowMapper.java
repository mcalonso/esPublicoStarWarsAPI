package com.Espublico.StarWarsAPI.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Espublico.StarWarsAPI.Models.Film;

public class FilmRowMapper implements RowMapper<Film> {

	@Override
	public Film mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Film film = new Film();
		film.setId(rs.getInt("ID"));
		film.setTitle(rs.getString("TITLE"));
		film.setEpisodeId(rs.getString("EPISODE"));
		film.setOpeningCrawl(rs.getString("OPENING_CRAWL"));
		film.setDirector(rs.getString("DIRECTOR"));
		film.setProducer(rs.getString("PRODUCER"));
		film.setReleaseDate(rs.getDate("RELEASE_DATE"));
		film.setCreated(rs.getDate("CREATED"));
		film.setEdited(rs.getDate("EDITED"));
		film.setUrl(rs.getString("URL"));
		
		return film;
	}

}
