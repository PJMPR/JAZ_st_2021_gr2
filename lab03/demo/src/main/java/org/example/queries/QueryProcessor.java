package org.example.queries;

import org.example.filters.*;
import org.example.functions.Functions;
import org.example.model.People;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.List;

public class QueryProcessor {

    List<Filter> filters = List.of(
            new FilterFromAge(),
            new FilterToAge(),
            new FilterGender(),
            new FilterFromIncome(),
            new FilterToIncome(),
            new FilterSurname(),
            new FilterName(),
            new FilterPage()
    );

    public Results GetResults(SearchParameters parameters){
        Results result = new Results();

        result.setItems(People.Data);

        filters.forEach(filter -> filter.meetCriteria(result, parameters));

        Functions functions = new Functions();
        functions.applyFunctions(result,parameters);

        return result;
    }
}
