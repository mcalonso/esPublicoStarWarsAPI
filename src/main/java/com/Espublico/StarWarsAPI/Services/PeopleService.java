package com.Espublico.StarWarsAPI.Services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Espublico.StarWarsAPI.Mapper.PeopleList;
import com.Espublico.StarWarsAPI.Models.People;
import com.Espublico.StarWarsAPI.Repositories.PeopleRepository;

@Service
public class PeopleService {

	@Autowired
	private PeopleRepository peopleRepositoy;
	
	public void save(People people) {
		peopleRepositoy.save(people);
	}
	
	public void savePeopleXStarship(String url, String starship) {
		peopleRepositoy.savePeopleXStarship(url, starship);
	}
	
	public List<People> findAll() {
		return peopleRepositoy.findAll();
	}
	
	public void getAPIPeople() {
		try {
			String url_people = "https://swapi.py4e.com/api/people/";
			RestTemplate restTemplate = new RestTemplate();
			do {
				PeopleList peopleList = restTemplate.getForObject(url_people, PeopleList.class);
				List<People> lpeople = peopleList.getResults();
				for(People people : lpeople) {
					save(people);
					for(String starship : people.getStarships()) {
						savePeopleXStarship(people.getUrl(), starship);
					}
				}
				url_people = peopleList.getNext();
			} while(url_people != null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Map<String, Object>> findCountByFilms() {
		return peopleRepositoy.findCountByFilms();
	}
	
	public List<Map<String, Object>> findCountPilot(String films) {
		List<Map<String, Object>> map = peopleRepositoy.findCountPilot(films);
		return map;
	}
}
