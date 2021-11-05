package org.example.queries;

import org.example.model.People;
import org.example.queries.criteria.*;
import org.example.queries.functions.Function;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.List;

public class QueryProcessor {


        List<Criteria> criteriaList = List.of(
                new AgeCriteria(),
                new GenderCriteria(),
                new IncomeCriteria(),
                new NameCriteria(),
                new SurnameCriteria(),
                new PageCriteria()

        );
    public Results GetResults(SearchParameters parameters){
        Results results = new Results();

        results.setItems(People.Data);

        criteriaList.forEach(criteria -> criteria.meetCriteria(results,parameters));
        Function functions = new Function();
        functions.implementFunction(results,parameters);


        return results;
    }
}
