package org.example.queries;

import org.example.model.People;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;
import org.example.queries.search.filter.*;

import java.util.List;


public class QueryProcessor {
    List<Filter> filterList = List.of(
            new fromAgeFilter(),
            new fromIncomeFilter(),
            new GenderFilter(),
            new nameFilter(),
            new pageFilter(),
            new surnameFilter(),
            new toAgeFilter(),
            new toIncomeFilter()
    );

    public Results GetResults(SearchParameters parameters){
        Results result = new Results();
        result.setItems(People.Data);
        filterList.forEach(filter -> filter.useFilter(result,parameters));
        return result;
    }


}
