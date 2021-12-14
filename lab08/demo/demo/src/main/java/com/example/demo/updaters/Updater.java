package com.example.demo.updaters;

import com.example.demo.contract.MovieDto;
import com.example.demo.contract.OMDbDto;
import com.example.demo.controllers.UpdaterController;
import com.example.demo.repositories.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class Updater {
    private final Logger logger = Logger.getLogger(UpdaterController.class.getName());

    public void update(RestTemplate rest, CategoryRepository categoryRepository, FilmCategoryRepository filmCategoryRepository, LanguageRepository languageRepository, ActorsRepository actorsRepository, FilmActorsRepository filmActorsRepository, FilmRepository filmRepository, int year) {
        Chain link1 = new LanguageUpdate(languageRepository);
        Chain link2 = new FilmUpdate(filmRepository, languageRepository);
        Chain link3 = new CategoryUpdate(categoryRepository, filmCategoryRepository, filmRepository);
        Chain link4 = new ActorsUpdate(actorsRepository, filmActorsRepository, filmRepository);


        link1.setNextChain(link2);
        link2.setNextChain(link3);
        link3.setNextChain(link4);

        int id = 2;
        logger.log(Level.INFO, "Updating database has been started");
        while (true) {
            try {
                var dataFromMovieDB = rest.getForEntity("https://api.themoviedb.org/3/movie/" + id + "?api_key=" + System.getenv("TheMovieDbApiKey"), MovieDto.class).getBody();
                var dataFromOMDb = rest.getForEntity("http://www.omdbapi.com/?apikey=" + System.getenv("OMDbAPIKey") + "&i=" + dataFromMovieDB.getImdb_id(), OMDbDto.class).getBody();

                if (Integer.parseInt((dataFromMovieDB.getRelease_date().split("-"))[0]) >= year && !dataFromMovieDB.getImdb_id().equals("")) {
                    link1.query(dataFromMovieDB, dataFromOMDb);
                }
                id++;
            } catch (HttpClientErrorException e) {
                id++;
                logger.log(Level.WARN, "Skipped deleted movie from Moviedb");
            }
        }
    }
}
