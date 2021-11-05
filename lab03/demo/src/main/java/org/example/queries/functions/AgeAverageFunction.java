package org.example.queries.functions;

import org.example.queries.results.FunctionResult;
import org.example.queries.results.Results;
import org.example.queries.search.Funcs;
import org.example.queries.search.SearchParameters;

import java.util.stream.Collectors;

public class AgeAverageFunction {
    public static FunctionResult ageAverage(Results results){
        FunctionResult functionResult = new FunctionResult();

        functionResult.setValue(
                results
                        .getItems()
                        .stream()
                        .collect(Collectors.averagingInt(person -> person.getAge())));

        return functionResult;
    }
}
