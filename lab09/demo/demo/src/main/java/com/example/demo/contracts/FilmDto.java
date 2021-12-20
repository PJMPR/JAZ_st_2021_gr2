package com.example.demo.contracts;

import java.math.BigDecimal;

public interface FilmDto {
    int getId();

    int getReplacementCost();
    
    String getTitle();

    int getYear();
    
    LanguageDto getLanguage();
    
    BigDecimal getRentalDuration();
    
    BigDecimal getRentalRate();
}

/*
*     releaseYear?:number,
    language?:Language,
    rentalDuration?:number,
    rentalRate?:number,
    replacementCosts?:number
* */