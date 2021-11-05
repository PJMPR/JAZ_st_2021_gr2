package org.example.queries;

import org.example.model.People;
import org.example.queries.filters.*;
import org.example.queries.functions.FunctionsResults;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.List;

public class QueryProcessor {

    List<Filter> filters = List.of(
            new NameFilter(),
            new SurnameFilter(),
            new FromAgeFilter(),
            new ToAgeFilter(),
            new FromIncomeFilter(),
            new ToIncomeFilter(),
            new GenderFilter()
    );

    public Results GetResults(SearchParameters parameters){
        Results results = new Results();

        results.setItems(People.Data);

        filters.forEach(filter -> filter.meetCriteria(results, parameters));

        FunctionsResults functions = new FunctionsResults();
        functions.functionsResults(results, parameters);

        return results;
    }
}
