package com.example.demo.services;

import com.example.demo.contracts.FilmDto;
import com.example.demo.contracts.LanguageDto;
import com.example.demo.repositories.FilmsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Transactional
@Service
public class FilmsService {
    private final FilmsRepository filmsRepository;
}
