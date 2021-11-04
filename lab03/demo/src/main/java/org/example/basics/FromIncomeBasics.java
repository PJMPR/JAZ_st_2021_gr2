package org.example.basics;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.stream.Collectors;

public class FromIncomeBasics implements BasicInterface {
    @Override
    public void useBasicInterface(Results results, SearchParameters searchParameters) {
        results.setItems(results.getItems().stream().filter(person -> person.getIncome() >= searchParameters.getIncomeFrom()).collect(Collectors.toList()));
    }
}
