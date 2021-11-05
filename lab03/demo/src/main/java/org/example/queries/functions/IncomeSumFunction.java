package org.example.queries.functions;

import org.example.queries.results.FunctionResult;
import org.example.queries.results.Results;
import org.example.queries.search.Funcs;
import org.example.queries.search.SearchParameters;

public class IncomeSumFunction {
    public static FunctionResult incomeSum(Results results){
        FunctionResult functionResult = new FunctionResult();

        functionResult.setValue(
                results
                        .getItems()
                        .stream()
                        .mapToDouble(person -> person.getIncome()).sum());

        return functionResult;
    }
}
