package org.example.queries;

import org.example.model.People;
import org.example.model.Person;
import org.example.queries.results.Results;
import org.example.queries.search.Filters.*;
import org.example.queries.search.SearchParameters;

import java.util.ArrayList;
import java.util.List;

public class QueryProcessor {

    public Results GetResults(SearchParameters parameters){
        Results result = new Results();
        List<Person> people = People.Data;

        PersonFilter[] filters = {
                new PageFilter(),
                new GenderFilter(),
                new IncomeFilter(),
                new AgeFilter(),
                new NameFilter(),
                new SurnameFilter()

        };


        List<Person> finish = new AndFilter(filters).meetCriteria(people, parameters);
        result.setItems(finish);


        return result;
    }
}
