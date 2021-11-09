package org.example.queries;

import org.example.model.People;
import org.example.queries.criteria.CriteriaName;
import org.example.queries.criterias.*;
import org.example.queries.results.PageResult;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.List;

public class QueryProcessor {

    public List<Criteria> criteriaList = List.of (
            new SimpleCriteria(params->params.getAgeFrom()>0,
                              (person,params)->person.getAge()>person.getAgeFrom())
            new CriteriaAge(),
            new CriteriaGender(),
            new CriteriaIncome(),
            new CriteriaName(),
            new CriteriaSurname()
    );

    public Results GetResults(SearchParameters parameters) {
        Results result = new Results();
        result.setItems(People.Data);

        for (Criteria Criteria : criteriaList)
            result.setItems(Criteria.meetCriteria(result.getItems(), parameters));

        FuncsProcessor funcsProcessor = new FuncsProcessor();
        result = funcsProcessor.returnResultObject(result, parameters);

        PageResult pageResult = new PageResult(result);
        result = pageResult.getCurrentResult(parameters);

        return result;
    }
}
