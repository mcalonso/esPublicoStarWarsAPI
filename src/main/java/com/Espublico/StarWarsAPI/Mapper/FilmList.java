package com.Espublico.StarWarsAPI.Mapper;

import java.util.ArrayList;
import java.util.List;

import com.Espublico.StarWarsAPI.Models.Film;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FilmList extends ObjectList{

	private static final long serialVersionUID = 1L;
	@JsonProperty("results")
	private List<Film> results;

	public FilmList() {
		results = new ArrayList<>();
    }

	public List<Film> getResults() {
		return results;
	}

	public void setResults(List<Film> results) {
		this.results = results;
	}
}
