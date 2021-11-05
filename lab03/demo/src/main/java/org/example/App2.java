package org.example;

import org.example.queries.QueryProcessor;
import org.example.queries.results.Results;
import org.example.queries.search.Funcs;
import org.example.queries.search.FunctionsParameters;
import org.example.queries.search.SearchParameters;
import org.example.queries.search.Page;
import org.example.model.Gender;

public class App2 {
    public static void main(String[] args){
        SearchParameters params =new SearchParameters();
        params.setAgeFrom(20);
        params.setAgeTo(40);
        params.setIncomeFrom(2000);
        params.setPage(new Page(9,1));
        params.getSelectedGenders().add(Gender.FEMALE);
        params.getSelectedGenders().add(Gender.OTHER);
        params.getFunctions().add(new FunctionsParameters("age", Funcs.AVARAGE));
        params.getFunctions().add(new FunctionsParameters("income", Funcs.SUM));
        params.getFunctions().add(new FunctionsParameters("income", Funcs.AVARAGE));
        Results results = QueryProcessor.GetResults(params);
        results.getItems().stream()
        .map(person -> person.getName()+ " "+ person.getSurname()+ " " + person.getAge())
                .forEach(fullname->System.out.println(fullname));

    }

    public static class App {
    }
}
