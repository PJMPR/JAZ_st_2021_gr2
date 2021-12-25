package com.example.demo.contracts;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmDto {
    private Long id;
    private String title;
    private Integer releaseYear;
    private LanguageDto language;
    private Integer rentalDuration;
    private BigDecimal rentalRate;
    private BigDecimal replacementCosts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public LanguageDto getLanguage() {
        return language;
    }

    public void setLanguage(LanguageDto language) {
        this.language = language;
    }

    public Integer getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(Integer rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    public BigDecimal getReplacementCosts() {
        return replacementCosts;
    }

    public void setReplacementCosts(BigDecimal replacementCosts) {
        this.replacementCosts = replacementCosts;
    }
}

/*
*     releaseYear?:number,
    language?:Language,
    rentalDuration?:number,
    rentalRate?:number,
    replacementCosts?:number
* */