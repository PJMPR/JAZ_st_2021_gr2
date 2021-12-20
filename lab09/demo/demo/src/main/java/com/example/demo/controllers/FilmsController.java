package com.example.demo.controllers;

import com.example.demo.contracts.FilmDto;
import com.example.demo.contracts.LanguageDto;
import com.example.demo.repositories.FilmsRepository;
import com.example.demo.services.FilmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("api/films")
@RequiredArgsConstructor
public class FilmsController {

    private final FilmsService filmsService;

    private static final List<FilmDto> films = List.of(
            new FilmDto((long)1,"Tytul", 2000, new LanguageDto(1, "polish"), new BigDecimal(2.99), 3),
            new FilmDto((long)2,"Tytul", 2000, new LanguageDto(1, "polish"), new BigDecimal(2.99), 3),
            new FilmDto((long)3,"Tytul", 2000, new LanguageDto(1, "polish"), new BigDecimal(2.99), 3),
            new FilmDto((long)4,"Tytul", 2000, new LanguageDto(1, "polish"), new BigDecimal(2.99), 3),
            new FilmDto((long)5,"Tytul", 2000, new LanguageDto(1, "polish"), new BigDecimal(2.99), 3),
            new FilmDto((long)6,"Tytul", 2000, new LanguageDto(1, "polish"), new BigDecimal(2.99), 3),
            new FilmDto((long)7,"Tytul", 2000, new LanguageDto(1, "polish"), new BigDecimal(2.99), 3),
            new FilmDto((long)8,"Tytul", 2000, new LanguageDto(1, "polish"), new BigDecimal(2.99), 3),
            new FilmDto((long)9,"Tytul", 2000, new LanguageDto(1, "polish"), new BigDecimal(2.99), 3)

    ).stream().collect(Collectors.toList());

    @GetMapping
    public ResponseEntity<List<FilmDto>> getFilms(){
        return ResponseEntity.ok(films);
    }

}
