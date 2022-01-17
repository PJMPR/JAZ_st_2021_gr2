package com.example.demo.contracts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmDto {

    private Long id;
    private String Title;
    private Integer releaseYear;
    private LanguageDto language;
    private BigDecimal rentalRate;
    private Integer rentalDuration;

}

/*
*     releaseYear?:number,
    language?:Language,
    rentalDuration?:number,
    rentalRate?:number,
    replacementCosts?:number
* */