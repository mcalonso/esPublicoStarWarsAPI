package com.Espublico.StarWarsAPI.Models;

import java.util.Date;
import java.util.List;

import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Table("FILMS")
public class Film {

	private Integer id;
	private String title;
	@JsonProperty("episode_id")
	private String episodeId;
	@JsonProperty("opening_crawl")
	private String openingCrawl;
	private String director;
	private String producer;
	@JsonProperty("release_date")
	private Date releaseDate;
	private Date created;
	private Date edited;
	private String url;
	
	private List<String> characters;
	private List<String> starships;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEpisodeId() {
		return episodeId;
	}
	public void setEpisodeId(String episodeId) {
		this.episodeId = episodeId;
	}
	public String getOpeningCrawl() {
		return openingCrawl;
	}
	public void setOpeningCrawl(String openingCrawl) {
		this.openingCrawl = openingCrawl;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
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
	
	public List<String> getCharacters() {
		return characters;
	}
	public void setCharacters(List<String> characters) {
		this.characters = characters;
	}
	public List<String> getStarships() {
		return starships;
	}
	public void setStarships(List<String> starships) {
		this.starships = starships;
	}
	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", episodeId=" + episodeId + ", openingCrawl=" + openingCrawl
				+ ", director=" + director + ", producer=" + producer + ", releaseDate=" + releaseDate + ", created="
				+ created + ", edited=" + edited + ", url=" + url + "]";
	}

}
