package com.example.demo.controllers;

import com.example.demo.contracts.FilmDto;
import com.example.demo.services.LanguagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/languages")
public class LanguageController {
    private final LanguagesService service;

    @Autowired
    public LanguageController(LanguagesService service)
    {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<FilmDto>> getLanguages()
    {
        List<FilmDto> languages = service.getLanguages();
        return ResponseEntity.ok(languages);
    }
}
