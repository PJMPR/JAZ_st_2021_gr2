package org.example.queries.functions;

import org.example.queries.results.FunctionResult;
import org.example.queries.results.Results;
import org.example.queries.search.Funcs;
import org.example.queries.search.FunctionsParameters;
import org.example.queries.search.SearchParameters;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.example.queries.functions.AgeAverageFunction.ageAverage;
import static org.example.queries.functions.AgeSumFunction.ageSum;
import static org.example.queries.functions.IncomeAverageFunction.incomeAverage;
import static org.example.queries.functions.IncomeSumFunction.incomeSum;

public class Function {
    public void implementFunction(Results results, SearchParameters searchParameters){

        List<FunctionResult> functionResults = new ArrayList<>();


        for (FunctionsParameters f : searchParameters.getFunctions()) {
            if(f.getFunction() == Funcs.AVARAGE) {
                if (Objects.equals(f.getFieldName(), "age")) {
                    functionResults.add(ageAverage(results));
                }
                else if (Objects.equals(f.getFieldName(), "income")) {
                    functionResults.add(incomeAverage(results));
                }
            }
            else if(f.getFunction() == Funcs.SUM){
                if(Objects.equals(f.getFieldName(), "age")){
                    functionResults.add(ageSum(results));
                }
                else if(Objects.equals(f.getFieldName(), "income")){
                    functionResults.add(incomeSum(results));
                }
            }

        }
        results.setFunctionResults(functionResults);
    }








}
