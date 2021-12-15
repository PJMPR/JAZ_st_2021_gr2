package com.example.demo.service;

import com.example.demo.contract.MovieDto;
import com.example.demo.quartz.DBUpdate;
import com.example.demo.quartz.SynchronizationInfo;
import com.example.demo.status.SystemStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class FilmService {
    private final RestTemplate restTemplate;
    @Value("${themoviedb.api.key}")
    String apiKey;

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(FilmService.class));
    FileHandler fileHandler;
    private final SystemStatus systemStatus;
    private final SynchronizationService schedulerService;

    public MovieDto getMovie(int id){
        var movie =  restTemplate.getForEntity("https://api.themoviedb.org/3/movie/" + id + "?api_key=" + apiKey, MovieDto.class).getBody();
        return movie;
    }

    public void runDataBaseChecker(){
        final SynchronizationInfo info = new SynchronizationInfo();
        info.setRunForever(false);
        info.setRepeatIntervals(24);
        info.setStartHour(2);

        schedulerService.scheduler(DBUpdate.class,info);
    }

    public SystemStatus getSystemStatusInfo() {
        return systemStatus;
    }

    public String reloadData() {
        return "Reloading...";
    }

    public  String reloadDataByYear(int year) {
        return "Reloading...";
    }
}