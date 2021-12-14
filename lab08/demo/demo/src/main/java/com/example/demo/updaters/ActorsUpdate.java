package com.example.demo.updaters;

import com.example.demo.contract.MovieDto;
import com.example.demo.contract.OMDbDto;
import com.example.demo.model.Actor;
import com.example.demo.model.FilmActor;
import com.example.demo.repositories.ActorsRepository;
import com.example.demo.repositories.FilmActorsRepository;
import com.example.demo.repositories.FilmRepository;
import com.example.demo.repositories.interfaces.IActors;
import com.example.demo.repositories.interfaces.IFilm;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ActorsUpdate implements Chain {
    private final Logger logger = Logger.getLogger(ActorsUpdate.class.getName());

    private Chain nextInChain;
    private ActorsRepository actorsRepository;
    private FilmRepository filmRepository;
    private FilmActorsRepository filmActorsRepository;

    public ActorsUpdate(ActorsRepository actorsRepository, FilmActorsRepository filmActorsRepository, FilmRepository filmRepository) {
        this.actorsRepository = actorsRepository;
        this.filmRepository = filmRepository;
        this.filmActorsRepository = filmActorsRepository;
    }

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextInChain = nextChain;
    }

    @Override
    public void query(MovieDto movieDto, OMDbDto omDbDto) {
        List<String> filmTitle = filmRepository.getAllFilms().stream().map(IFilm::getTitle).collect(Collectors.toList());
        List<String> actorsList = Arrays.stream(omDbDto.getActors().split(", ")).toList();

        for (String actor : actorsList) {
            List<String> dbListFirstName = actorsRepository.getAllActors().stream().map(IActors::getFirstName).collect(Collectors.toList());
            List<String> dbListLastName = actorsRepository.getAllActors().stream().map(IActors::getLastName).collect(Collectors.toList());
            List<String> actorFirstAndLastName = new ArrayList<>(Arrays.asList(actor.split(" ")));
            long time = new Date().getTime();

            if (actorFirstAndLastName.size() == 1)
                actorFirstAndLastName.add(null);

            if (!actorFirstAndLastName.get(0).equals("N/A") && !dbListFirstName.contains(actorFirstAndLastName.get(0)) && !dbListLastName.contains(actorFirstAndLastName.get(1))) {
                Actor a = new Actor();
                a.setActorId(dbListFirstName.size() + 1);
                a.setFirstName(actorFirstAndLastName.get(0));
                a.setLastUpdate(new Timestamp(time));

                if (actorFirstAndLastName.get(1) != null) {
                    if (actorFirstAndLastName.size() == 3) {
                        a.setLastName(actorFirstAndLastName.get(1) + " " + actorFirstAndLastName.get(2));
                    } else {
                        a.setLastName(actorFirstAndLastName.get(1));
                    }
                } else {
                    a.setLastName("");
                }

                actorsRepository.save(a);
                logger.log(Level.INFO, "Found and added new actor: " + a.getFirstName() + " " + a.getLastName());
            }
            dbListFirstName = actorsRepository.getAllActors().stream().map(IActors::getFirstName).collect(Collectors.toList());

            if (!actorFirstAndLastName.get(0).equals("N/A")) {
                FilmActor filmActor = new FilmActor();
                filmActor.setFilmId(filmTitle.indexOf(movieDto.getTitle()) + 1);
                filmActor.setActorId(dbListFirstName.indexOf(actorFirstAndLastName.get(0)) + 1);
                filmActor.setLastUpdate(new Timestamp(time));

                filmActorsRepository.save(filmActor);
            }
        }
    }
}
