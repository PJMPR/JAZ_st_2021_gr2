package com.example.demo.controllers;

import com.example.demo.contracts.FilmDto;
import com.example.demo.model.Film;
import com.example.demo.repositories.FilmsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("api/films")
@RequiredArgsConstructor
public class FilmsController {

    private final FilmsRepository filmsRepository;


    @GetMapping
    public ResponseEntity<List<Film>> getFilms(@RequestParam int page) {
        List<Film> films = filmsRepository.getFilmsByPage(page, 5);
        return ResponseEntity.ok(films);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFilm(@PathVariable int id) {
        filmsRepository.deleteFilmById(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping
    public ResponseEntity createFilm(@RequestBody FilmDto newFilm) {
        filmsRepository.createFilm(newFilm);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity updateFilm(@PathVariable int id, @RequestBody FilmDto updateFilm) {
        filmsRepository.updateFilm(id, updateFilm);
        return ResponseEntity.ok().build();
    }
}