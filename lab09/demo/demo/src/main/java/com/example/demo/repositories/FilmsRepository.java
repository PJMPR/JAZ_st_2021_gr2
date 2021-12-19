package com.example.demo.repositories;

import com.example.demo.model.Film;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class FilmsRepository {

    private final EntityManager entityManager;

    public List<Film> getFilms(){

        return entityManager.createQuery("" +
                "SELECT  f FROM Film f WHERE f.releaseYear = 2006",
                        Film.class)
                .getResultList();
    }

}
