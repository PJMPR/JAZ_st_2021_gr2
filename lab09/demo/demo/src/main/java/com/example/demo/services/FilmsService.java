package com.example.demo.services;

import com.example.demo.repositories.FilmsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;

@RequiredArgsConstructor
@Service
public class FilmsService {

    private final EntityManager entityManager;
    private FilmsRepository filmsRepository;

    public void deleteFilm(int id) {
        entityManager.createQuery("DELETE from Film where filmId=:id").setParameter("id",id).executeUpdate();
    }
}