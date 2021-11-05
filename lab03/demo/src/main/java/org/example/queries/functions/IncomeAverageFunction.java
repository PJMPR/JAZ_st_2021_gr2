package org.example.queries.functions;

import org.example.queries.results.FunctionResult;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.stream.Collectors;

public class IncomeAverageFunction {
    public static FunctionResult incomeAverage(Results results){
        FunctionResult functionResult = new FunctionResult();

        functionResult.setValue(
                results
                        .getItems()
                        .stream()
                        .collect(Collectors.averagingDouble(person -> person.getIncome())));

        return functionResult;
    }
}
