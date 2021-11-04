package org.example.queries.search;

import org.example.model.Person;
import org.example.queries.results.FunctionResult;
import org.example.queries.results.Results;

import java.util.ArrayList;
import java.util.Locale;

public class FunctionSetter {

    public static void setFunctions(Results result, SearchParameters parameters) {
        ArrayList<FunctionResult> functionResults = new ArrayList<>();
        for (FunctionsParameters functionsParameters :
                parameters.getFunctions()) {
            FunctionResult functionResult = new FunctionResult();
            functionResult
                    .setFunction(functionsParameters
                            .getFunction());

            functionResult
                    .setFieldName(functionsParameters
                            .getFieldName());
            functionResult.
                    setValue(functionValue(result, functionsParameters));
            functionResults
                    .add(functionResult);
        }
        result.setFunctionResults(functionResults);
    }

    private static double functionValue(Results result, FunctionsParameters functionsParameters) {
        if(functionsParameters.getFunction() == Funcs.AVARAGE){
            return averageValue(result, functionsParameters.getFieldName());
        }else if(functionsParameters.getFunction() == Funcs.SUM){
            return sumValue(result, functionsParameters.getFieldName());
        }else{
            return 0;
        }
    }

    private static double averageValue(Results result, String fieldName) {
        return sumValue(result, fieldName)/result.getItems().size();
    }

    private static double sumValue(Results result, String fieldName) {
        if (fieldName.toLowerCase(Locale.ROOT).equals("age")){
            return result
                    .getItems()
                    .stream()
                    .mapToDouble(Person::getAge)
                    .sum();
        }else if (fieldName.toLowerCase(Locale.ROOT).equals("income")){
            return result
                    .getItems()
                    .stream()
                    .mapToDouble(Person::getIncome)
                    .sum();
        }else {
            return 0;
        }
    }
}