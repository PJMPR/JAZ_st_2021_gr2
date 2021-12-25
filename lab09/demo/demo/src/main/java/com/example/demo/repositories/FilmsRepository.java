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

    public List<Film> getFilms(Integer page, String query) {
        return entityManager.createQuery(query,
                        Film.class)
                .setFirstResult(20 * (page - 1))
                .setMaxResults(20)
                .getResultList();
    }

    public void deleteFilm(Long id) {
        entityManager.remove(getFilm(id));
    }

    public void addFilm(Film film) {
        entityManager.persist(film);
    }

    public void updateFilm(Film film) {
        entityManager.merge(film);
    }

    public Film getFilm(Long filmId) {
        return entityManager.find(Film.class, filmId);
    }
}