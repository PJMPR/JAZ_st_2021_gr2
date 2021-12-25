package com.example.demo.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Language {
    private Integer languageId;
    private String name;
    private Timestamp lastUpdate;
    private Collection<Film> films;

    public Language() {
    }

    public Language(Integer languageId, String name) {
        this.languageId = languageId;
        this.name = name;
    }

    @Id
    @Column(name = "language_id")
    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Language language = (Language) o;
        return Objects.equals(languageId, language.languageId) && Objects.equals(name, language.name) && Objects.equals(lastUpdate, language.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(languageId, name, lastUpdate);
    }

    @OneToMany(mappedBy = "languageByLanguageId")
    public Collection<Film> getFilms() {
        return films;
    }

    public void setFilms(Collection<Film> films) {
        this.films = films;
    }
}