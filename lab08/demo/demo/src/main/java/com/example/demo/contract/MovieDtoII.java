package com.example.demo.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MovieDtoII {
    @JsonProperty("Rated")
    private String rating;

    @JsonProperty("Year")
    private int year;

    @JsonProperty("Language")
    private String language;

    @JsonProperty("Genre")
    private String genre;

    @JsonProperty("Actors")
    private String actors;
}
