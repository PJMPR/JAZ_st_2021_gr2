package com.example.demo.contract;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieDto {

    public int id;
    @JsonProperty("original_title")
    public String title;

    public String overview;

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

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
