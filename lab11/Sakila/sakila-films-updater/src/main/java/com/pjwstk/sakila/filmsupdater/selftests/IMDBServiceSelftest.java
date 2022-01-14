package com.pjwstk.sakila.filmsupdater.selftests;

import com.pjwstk.sakila.diagnostics.contract.SelfTestResult;
import com.pjwstk.sakila.diagnostics.selftests.SelftestBase;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;

@Component
public class IMDBServiceSelftest extends SelftestBase {

    @Override
    public String getName() {
        return "CheckIMDBServiceConnection";
    }

    @Override
    public String getDescription() {
        return "checking if there is a connection to the IMDBService";
    }

    @Override
    public SelfTestResult execute() {
        SelfTestResult selftestResult = new SelfTestResult(getName(), getDescription(), false, null);
        try{
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            headers.add("x-rapidapi-host", "movie-database-imdb-alternative.p.rapidapi.com");
            headers.add("x-rapidapi-key", "$58f2619005msh56b70af0887cd9ap1dcd05jsndc4c308a6413");

            HttpEntity<String> entity = new HttpEntity<>("body", headers);

            restTemplate.exchange("https://movie-database-imdb-alternative.p.rapidapi.com/?s=Avengers%20Endgame&r=json&page=1", HttpMethod.GET, entity, String.class);
            selftestResult.setPassed(true);
        } catch (HttpClientErrorException e){
            selftestResult.setPassed(false);
            selftestResult.setErrors(Arrays.asList(e.getMessage()));
        }
        return selftestResult;
    }
}
