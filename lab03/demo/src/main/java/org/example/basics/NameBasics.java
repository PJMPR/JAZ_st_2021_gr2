package org.example.basics;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.Locale;
import java.util.stream.Collectors;

public class NameBasics implements BasicInterface{
    @Override
    public void useBasicInterface(Results results, SearchParameters searchParameters) {
        if(searchParameters.getName() != null){
            results.setItems(results.getItems().stream().filter(person -> person.getName().toLowerCase(Locale.ROOT).equals(searchParameters.getName().toLowerCase(Locale.ROOT))).collect(Collectors.toList()));
        }
    }
}
