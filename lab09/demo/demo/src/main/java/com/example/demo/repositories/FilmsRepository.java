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

    public List<Film> getFilmsByPage(int page, int size){

        return entityManager.createQuery("" + "SELECT film FROM FILM film", Film.class)
                .setFirstResult((page-1)*size).setMaxResults(size).getResultList();
    }

}
