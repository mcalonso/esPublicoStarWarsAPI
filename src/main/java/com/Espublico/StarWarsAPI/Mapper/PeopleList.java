package com.Espublico.StarWarsAPI.Mapper;

import java.util.ArrayList;
import java.util.List;

import com.Espublico.StarWarsAPI.Models.People;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PeopleList extends ObjectList {

	private static final long serialVersionUID = 1L;
	@JsonProperty("results")
	private List<People> results;

	public PeopleList() {
		results = new ArrayList<>();
    }

	public List<People> getResults() {
		return results;
	}

	public void setResults(List<People> results) {
		this.results = results;
	}
}
