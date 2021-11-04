package org.example.queries;

import org.example.MainFunction;
import org.example.model.People;
import org.example.queries.AllFilters.*;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;
import java.util.List;

public class QueryProcessor {

    List<Filter> filters = List.of(

            new FromIncomeFilter(),
            new ToIncomeFilter(),
            new FromAgeFilter(),
            new ToAgeFilter(),
            new NameFilter(),
            new SurnameFilter(),
            new GenderFilter(),
            new PagingFilter()

    );

    public Results GetResults(SearchParameters parameters){
        Results result = new Results();
        MainFunction function = new MainFunction();

        result.setItems(People.Data);

        filters.forEach(filter -> filter.meetCriteria(result, parameters));

        MainFunction methods = new MainFunction();
        function.Function(parameters, result);

        return result;
    }
}
