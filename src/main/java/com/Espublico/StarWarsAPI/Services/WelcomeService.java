package com.Espublico.StarWarsAPI.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Espublico.StarWarsAPI.Repositories.WelcomeRepository;

@Service
public class WelcomeService {

	@Autowired
	private WelcomeRepository welcomeRepository;
	
	public boolean getCountFilm() {
        return welcomeRepository.getCountFilm(); 
	}
	
	public boolean getCountPeople() {
	        return welcomeRepository.getCountPeople(); 
		}
	
	public boolean getCountStarship() {
	    return welcomeRepository.getCountStarship(); 
	}
}
