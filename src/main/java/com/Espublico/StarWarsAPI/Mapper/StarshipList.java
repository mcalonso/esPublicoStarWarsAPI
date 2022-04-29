package com.Espublico.StarWarsAPI.Mapper;

import java.util.ArrayList;
import java.util.List;

import com.Espublico.StarWarsAPI.Models.Starship;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StarshipList extends ObjectList {

	private static final long serialVersionUID = 1L;
	@JsonProperty("results")
	private List<Starship> results;
	
	public StarshipList() {
		results = new ArrayList<>();
    }

	public List<Starship> getResults() {
		return results;
	}

	public void setResults(List<Starship> results) {
		this.results = results;
	}
}
