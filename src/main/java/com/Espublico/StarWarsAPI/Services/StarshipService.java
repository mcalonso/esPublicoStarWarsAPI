package com.Espublico.StarWarsAPI.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Espublico.StarWarsAPI.Mapper.StarshipList;
import com.Espublico.StarWarsAPI.Models.Starship;
import com.Espublico.StarWarsAPI.Repositories.StarshipRepository;

@Service
public class StarshipService {

	@Autowired
	private StarshipRepository starshipRepository;
	
	public void save(Starship starship) {
		starshipRepository.save(starship);
	}
	
	public List<Starship> findAll(){
		return starshipRepository.findAll();
	}
	
	public void getAPIStarships() {
		try {
			String url_starship = "https://swapi.py4e.com/api/starships/";
			RestTemplate restTemplate = new RestTemplate();
			do {
				StarshipList starshipList = restTemplate.getForObject(url_starship, StarshipList.class);
				List<Starship> lstarship = starshipList.getResults();
				for(Starship starship : lstarship) {
					save(starship);
				}
				url_starship = starshipList.getNext();
			} while(url_starship != null);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
