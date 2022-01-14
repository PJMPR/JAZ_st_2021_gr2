package com.pjwstk.sakila.filmsupdater.selftests;

import com.pjwstk.sakila.diagnostics.contract.SelfTestResult;
import com.pjwstk.sakila.diagnostics.selftests.SelftestBase;
import org.springframework.stereotype.Component;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

@Component
public class TheMovieDbServiceSelftest extends SelftestBase {

    @Override
    public String getName() {
        return "CheckMovieDbServiceConection";
    }

    @Override
    public String getDescription() {
        return "checking if there is a connection to the MovieDb service" ;
    }

    @Override
    public SelfTestResult execute() throws Exception {
        SelfTestResult selftestResult = new SelfTestResult(getName(), getDescription(), false, null);
        try {

            URL url = new URL("https://api.themoviedb.org/3/movie/550?api_key=c268893b94d4f1d2600276e0eb7f0ce7");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            if (con.getResponseCode() == 200) {
                selftestResult.setPassed(true);
            }
        }catch(MalformedURLException e){
            selftestResult.setErrors(Arrays.asList(e.getMessage()));
            selftestResult.setPassed(false);
        }
        return selftestResult;
    }
}
