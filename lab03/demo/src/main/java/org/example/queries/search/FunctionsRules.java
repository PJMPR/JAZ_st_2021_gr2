package org.example.queries.search;

import org.example.queries.results.FunctionResult;
import org.example.queries.results.Results;

import java.util.*;


public abstract class FunctionsRules {
    public void applyFunctions(Results results, SearchParameters searchParameters){
        List<FunctionResult> functionResults = new ArrayList<>();
        for (FunctionsParameters f : searchParameters.getFunctions()) {
            if (f.getFunction() == Funcs.SUM) {

                if (Objects.equals(f.getFieldName(), "age")) {
                    functionResults.add(sumAge(results, searchParameters));
                }

                if (Objects.equals(f.getFieldName(), "income")) {
                    functionResults.add(sumIncome(results, searchParameters));
                }

            } else if (f.getFunction() == Funcs.AVERAGE) {

                if (Objects.equals(f.getFieldName(), "age")) {
                    functionResults.add(averageAge(results, searchParameters));
                }

                if (Objects.equals(f.getFieldName(), "income")) {
                    functionResults.add(averageIncome(results, searchParameters));
                }
            }
        }
        results.setFunctionResults(functionResults);
    }
    protected abstract FunctionResult sumAge(Results results, SearchParameters searchParameters);

    protected abstract FunctionResult sumIncome(Results results, SearchParameters searchParameters);

    protected abstract FunctionResult averageAge(Results results, SearchParameters searchParameters);

    protected abstract FunctionResult averageIncome(Results results, SearchParameters searchParameters);
}
