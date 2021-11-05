package org.example.queries.search.filter;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.stream.Collectors;

public class toAgeFilter implements Filter{
    @Override
    public void useFilter(Results results, SearchParameters searchParameters) {
        results.setItems(
                results.getItems()
                        .stream()
                        .filter(person -> person.getAge()<=searchParameters.getAgeTo())
                        .collect(Collectors.toList()));
    }
}
