package com.example.demo.services;

import com.example.demo.contracts.FilmDto;
import com.example.demo.repositories.LanguagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguagesService {
    private final LanguagesRepository repo;

    @Autowired
    public LanguagesService(LanguagesRepository repo)
    {
        this.repo = repo;
    }

    @Cacheable(value = "languages")
    public List<FilmDto> getLanguages()
    {
        return repo.findAllLanguages();
    }
}