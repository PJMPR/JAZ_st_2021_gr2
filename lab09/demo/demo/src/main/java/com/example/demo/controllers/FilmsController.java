package com.example.demo.controllers;

import com.example.demo.contracts.FilmDto;
import com.example.demo.model.Film;
import com.example.demo.model.Language;
import com.example.demo.services.FilmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("api/films")
public class FilmsController {
    private final FilmsService filmsService;
    
    @Autowired
    public FilmsController(FilmService service){
        this.service = service;
    }
    
    @GetMapping
    public ResponseEntity<List<FilmDto>> getFilms(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false) Language language,
            @RequestParam(required = false) Integer release_year,
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Integer rental_duration,
            @RequestParam(required = false) BigDecimal rental_rate,
            @RequestParam(required = false) BigDecimal replacement_cost
    ){
        List<FilmDto> films = service.getAllFilms(page - 1, language, release_year, title, rental_duration, rental_rate, replacement_cost);
        return new ResponseEntity<>(films, HttpStatus.OK);
    }
    
    
    //entity for creating films
    @PostMapping
    public ResponseEntity<Long> createFilm(@RequestBody Film film) {
        long createdId = service.addFilm(film);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }
    //entity for changing already exisiting films
    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateFilm(@PathVariable int id, @RequestBody Film film) {
        int updateId = service.putFilm(id, film);
        return new ResponseEntity<>(updateId, HttpStatus.OK);
    }
    
    //entity for deleting already existing films
    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteFilm(@PathVariable int id) {
        int deletedId = service.deleteFilm(id);
        return new ResponseEntity<>(deletedId, HttpStatus.OK);
    }
}
        