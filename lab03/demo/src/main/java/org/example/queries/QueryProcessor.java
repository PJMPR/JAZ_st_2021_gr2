package org.example.queries;

import org.example.filters.*;
import org.example.model.People;
import org.example.queries.results.Results;
import org.example.queries.search.Functions;
import org.example.queries.search.SearchParameters;

import java.util.List;

public class QueryProcessor {


    List<FilterInterface> filters = List.of(
            new GenderFilter(),
            new NameFilter(),
            new SurnameFilter(),
            new FromIncomeFilter(),
            new ToIncomeFilter(),
            new FromAgeFilter(),
            new ToAgeFilter(),
            new PageFilter()

    );

    public Results GetResults(SearchParameters parameters) {
        Results result = new Results();
        result.setItems(People.Data);
        filters.forEach(filter -> filter.meetCriteria(result, parameters));

        Functions functions = new Functions();
        functions.applyFunctions(result,parameters);

        return result;
    }
}
