package org.example.queries.search.functions;

import org.example.queries.results.FunctionResult;
import org.example.queries.results.Results;
import org.example.queries.search.Funcs;
import org.example.queries.search.FunctionsParameters;
import org.example.queries.search.SearchParameters;

import java.util.ArrayList;
import java.util.List;

public class functionList {
    functions calculations = new functions();
    public void Function(SearchParameters searchParameters, Results results) {
        List<FunctionResult> functionResults = new ArrayList<>();
        for (FunctionsParameters f : searchParameters.getFunctions()) {

            if (f.getFunction() == Funcs.AVARAGE) {
                switch (f.getFieldName()) {
                    case "income" ->
                            functionResults.add(calculations.averageIncome(results));
                    case "age" ->
                            functionResults.add(calculations.averageAge(results));
                }
            }

            else if (f.getFunction() == Funcs.SUM) {
                switch (f.getFieldName()){
                    case "income" ->
                            functionResults.add(calculations.sumIncome(results));
                    case "age" ->
                            functionResults.add(calculations.sumAge(results));
                }
            }
        }
        results.setFunctionResults(functionResults);
    }
}
