package com.example.demo.contracts;

import java.math.BigDecimal;

public interface FilmDto {
    int getId();
    String getTitle();
    LanguageDto getLanguage();
    int getReleaseYear();
    int getRentalDuration();
    BigDecimal getRentalRate();
    BigDecimal getReplacementCosts();
}