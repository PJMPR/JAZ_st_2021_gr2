package com.example.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Film {
    private Long filmId;
    private String title;
    private Integer releaseYear;
    private Integer rentalDuration;
    private BigDecimal rentalRate;
    private BigDecimal replacementCost;
    private Timestamp lastUpdate;
    private Language languageByLanguageId;

    public Film() {
    }

    public Film(Long filmId, String title, Integer releaseYear, Integer rentalDuration, BigDecimal rentalRate, BigDecimal replacementCost, Timestamp lastUpdate, Language languageByLanguageId) {
        this.filmId = filmId;
        this.title = title;
        this.releaseYear = releaseYear;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.replacementCost = replacementCost;
        this.lastUpdate = lastUpdate;
        this.languageByLanguageId = languageByLanguageId;
    }

    @Id
    @Column(name = "film_id")
    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "release_year")
    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Basic
    @Column(name = "rental_duration")
    public Integer getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(Integer rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    @Basic
    @Column(name = "rental_rate")
    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    @Basic
    @Column(name = "replacement_cost")
    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    @Basic
    @Column(name = "last_update")
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(filmId, film.filmId) && Objects.equals(title, film.title) && Objects.equals(releaseYear, film.releaseYear) && Objects.equals(rentalDuration, film.rentalDuration) && Objects.equals(rentalRate, film.rentalRate) && Objects.equals(replacementCost, film.replacementCost) && Objects.equals(lastUpdate, film.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, title, releaseYear, rentalDuration, rentalRate, replacementCost, lastUpdate);
    }

    @ManyToOne
    @JoinColumn(name = "language_id", referencedColumnName = "language_id", nullable = false)
    public Language getLanguageByLanguageId() {
        return languageByLanguageId;
    }

    public void setLanguageByLanguageId(Language languageByLanguageId) {
        this.languageByLanguageId = languageByLanguageId;
    }
}