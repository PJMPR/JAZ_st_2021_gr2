package com.example.demo.services;

import com.example.demo.contracts.FilmDto;
import com.example.demo.model.Film;
import com.example.demo.model.Language;
import com.example.demo.repositories.FilmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FilmsService {
    private final FilmsRepository filmsRepository;

    @Autowired
    public FilmsService(FilmsRepository filmsRepository) {
        this.filmsRepository = filmsRepository;
    }
    
    public long addFilm(Film film) {
        return filmsRepository.save(film).getId();
    }

    public int deleteFilm(int id) {
        filmsRepository.deleteById(id);
        return id;
    }
    
    public List<FilmDto> getFilms(int page, Language language, Integer release_year, Integer id, String title, Integer rental_duration, BigDecimal rental_rate, BigDecimal replacement_cost){
        Pageable pageable = PageRequest.of(page, 15);
        
        return filmsRepository.findAllFilms(pageable, id, release_year, title, rental_duration, rental_rate, replacement_cost, language).getContent();
    }
    
    public int putFilm(int id, Film film) {
        Film repoFilm = filmsRepository.findByFilmId(id);
        
        repoFilm.setTitle(film.getTitle());
        repoFilm.setLanguage(film.getLanguage());
        repoFilm.setReleaseYear(film.getReleaseYear());
        repoFilm.setRentalDuration(film.getRentalDuration());
        repoFilm.setRentalRate(film.getRentalRate());
        repoFilm.setReplacementCost(film.getReplacementCost());
        
        return filmsRepository.save(repoFilm).getFilmId;
    }
}
