package com.example.demo.controllers;

import com.example.demo.contract.MovieDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("movies-client")
public class MoviesController {
    FilmService filmService;
    
    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<MovieDto> getDataOfMovie(@PathVariable("id") int id){
        return ResponseEntity.ok(filmService.getMovieInfo(id));
    }

    @GetMapping
    @RequestMapping("/imdb/{id}")
    public ResponseEntity<IMDBMovieDto> getDataIMDB(@PathVariable("id") String id){
        return ResponseEntity.ok(filmService.getMovieInfoFromIMDB(id));
    }

    @GetMapping
    @RequestMapping("/updater/reload")
    public ResponseEntity reloadData() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        return ResponseEntity.ok(filmService.reloadData());
    }

    @GetMapping
    @RequestMapping("/updater/reload/{year}")
    public ResponseEntity reloadDataByYear(@PathVariable int year) {
        return ResponseEntity.ok(filmService.reloadDataByYear(year));
    }

    @PostMapping("/updater/status")
    public ResponseEntity getSystemStatus(){
        return ResponseEntity.ok(filmService.getSystemStatusInfo());
    }
}
