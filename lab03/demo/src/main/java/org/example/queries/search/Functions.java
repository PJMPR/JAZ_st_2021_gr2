package org.example.queries.search;

import org.example.model.Person;
import org.example.queries.results.FunctionResult;
import org.example.queries.results.Results;

import java.util.stream.Collectors;

public class Functions extends FunctionsRules{

    FunctionResult functionResult = new FunctionResult();
    @Override
    protected FunctionResult sumAge(Results results, SearchParameters searchParameters) {
        functionResult.setFunction(Funcs.SUM);
        functionResult.setValue(results
                .getItems()
                .stream()
                .mapToInt(Person::getAge)
                .sum());
        return functionResult;
    }

    @Override
    protected FunctionResult sumIncome(Results results, SearchParameters searchParameters) {
        functionResult.setFunction(Funcs.SUM);
        functionResult.setValue(results
                .getItems()
                .stream()
                .mapToDouble(Person::getIncome)
                .sum());
        return functionResult;
    }

    @Override
    protected FunctionResult averageAge(Results results, SearchParameters searchParameters) {
        functionResult.setFunction(Funcs.AVERAGE);
        functionResult.setValue(results
                .getItems()
                .stream()
                .collect(Collectors.averagingInt(Person::getAge)));
        return functionResult;
    }

    @Override
    protected FunctionResult averageIncome(Results results, SearchParameters searchParameters) {
        functionResult.setFunction(Funcs.AVERAGE);
        functionResult.setValue(results
                .getItems()
                .stream()
                .collect(Collectors.averagingDouble(Person::getIncome)));
        return functionResult;
    }
}
