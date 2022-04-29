package com.Espublico.StarWarsAPI.Models;

import java.util.Date;

import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Table("STARSHIP")
public class Starship {

	private Integer id;
	private String name;
	private String model;
	private String manufacturer;
	@JsonProperty("cost_in_credits")
	private String costInCredits;
	private String length;
	@JsonProperty("max_atmosphering_speed")
	private String maxAtmospheringSpeed;
	private String crew;
	private String passengers;
	@JsonProperty("cargo_capacity")
	private String cargoCapacity;
	private String consumables;
	@JsonProperty("hyperdrive_rating")
	private String hyperdriveRating;
	@JsonProperty("MGLT")
	private String mglt;
	@JsonProperty("starship_class")
	private String starshipClass;
	private Date created;
	private Date edited;
	private String url;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getCostInCredits() {
		return costInCredits;
	}
	public void setCostInCredits(String costInCredits) {
		this.costInCredits = costInCredits;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getMaxAtmospheringSpeed() {
		return maxAtmospheringSpeed;
	}
	public void setMaxAtmospheringSpeed(String maxAtmospheringSpeed) {
		this.maxAtmospheringSpeed = maxAtmospheringSpeed;
	}
	public String getCrew() {
		return crew;
	}
	public void setCrew(String crew) {
		this.crew = crew;
	}
	public String getPassengers() {
		return passengers;
	}
	public void setPassengers(String passengers) {
		this.passengers = passengers;
	}
	public String getCargoCapacity() {
		return cargoCapacity;
	}
	public void setCargoCapacity(String cargoCapacity) {
		this.cargoCapacity = cargoCapacity;
	}
	public String getConsumables() {
		return consumables;
	}
	public void setConsumables(String consumables) {
		this.consumables = consumables;
	}
	public String getHyperdriveRating() {
		return hyperdriveRating;
	}
	public void setHyperdriveRating(String hyperdriveRating) {
		this.hyperdriveRating = hyperdriveRating;
	}
	public String getMglt() {
		return mglt;
	}
	public void setMglt(String mglt) {
		this.mglt = mglt;
	}
	public String getStarshipClass() {
		return starshipClass;
	}
	public void setStarshipClass(String starshipClass) {
		this.starshipClass = starshipClass;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getEdited() {
		return edited;
	}
	public void setEdited(Date edited) {
		this.edited = edited;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
