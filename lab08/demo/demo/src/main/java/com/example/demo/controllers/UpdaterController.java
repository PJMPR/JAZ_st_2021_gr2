package com.example.demo.controllers;

import com.example.demo.repositories.*;
import com.example.demo.updaters.Updater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("updater")
public class UpdaterController {
    private final RestTemplate rest;
    private final CategoryRepository categoryRepository;
    private final FilmCategoryRepository filmCatRepository;
    private final LanguageRepository languageRepository;
    private final ActorsRepository actorsRepository;
    private final FilmActorsRepository filmActorsRepository;
    private final FilmRepository filmRepository;

    @Autowired
    public UpdaterController(RestTemplate rest, CategoryRepository categoryRepository, FilmCategoryRepository filmCatRepository, LanguageRepository languageRepository, ActorsRepository actorsRepository, FilmActorsRepository filmActorsRepository, FilmRepository filmRepository) {
        this.rest = rest;
        this.categoryRepository = categoryRepository;
        this.filmCatRepository = filmCatRepository;
        this.languageRepository = languageRepository;
        this.actorsRepository = actorsRepository;
        this.filmActorsRepository = filmActorsRepository;
        this.filmRepository = filmRepository;
    }

    @GetMapping
    @RequestMapping("/reload")
    public void reloadSakila(@RequestParam(required = false, defaultValue = "1980") int year) {
        new Updater().update(rest, categoryRepository, filmCatRepository, languageRepository,
                actorsRepository, filmActorsRepository, filmRepository, year);
    }
}
