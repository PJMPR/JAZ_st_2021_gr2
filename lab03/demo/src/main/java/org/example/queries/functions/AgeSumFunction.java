package org.example.queries.functions;

import org.example.queries.results.FunctionResult;
import org.example.queries.results.Results;


public class AgeSumFunction {
    public static FunctionResult ageSum(Results results){
        FunctionResult functionResult = new FunctionResult();

        functionResult.setValue(
                results
                        .getItems()
                        .stream()
                        .mapToInt(person -> person.getAge()).sum());

        return functionResult;
    }
}
