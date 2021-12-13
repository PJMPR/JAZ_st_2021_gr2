package com.example.demo.contract;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieDto {

    private int year;
    private String rating;
    
    private int id;
    @JsonProperty("original_title")
    private String title;
    @JsonProperty("runtime")
    private int runtime;
    @JsonProperty("overview")
    private String overview;
    private List<Actor> actors;
    private String imdb_id;

    public MovieDto(String title, int id, int runtime, String overview, int year, String rating, List<Actor> actors, String imdb_id) {
        this.title = title;
        this.id = id;
        this.runtime = runtime;
        this.overview = overview;
        this.year = year;
        this.rating = rating;
        this.actors = actors;
        this.imdb_id = imdb_id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getOriginalTitle() {
        return title;
    }

    public void setOriginalTitle(String title) {
        this.title = title;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }
    
}
