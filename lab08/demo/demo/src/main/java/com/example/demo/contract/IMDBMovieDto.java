package com.example.demo.contract;

import com.fasterxml.jackson.annotation.JsonProperty;


public class IMDBMovieDto {
    @JsonProperty("Year")
    private int year;
    @JsonProperty("Rated")
    private String rating;
    @JsonProperty("Actors")
    private String actors;
    @JsonProperty("Language")
    private String language;
    @JsonProperty("Genre")
    private String genre;

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}