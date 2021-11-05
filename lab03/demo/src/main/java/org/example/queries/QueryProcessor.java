package org.example.queries;

import org.example.model.People;
import org.example.model.Person;
import org.example.queries.criteria.*;
import org.example.queries.results.Results;
import org.example.queries.search.Page;
import org.example.queries.search.SearchParameters;

import java.util.List;

public class QueryProcessor {

    public Results GetResults(SearchParameters parameters){
        Results result = new Results();
        List<Person> persons = People.Data;
        List<Criteria> criterias = List.of(new Name(), new Surname(),new Gender(), new Age(), new Income());

        for(Criteria criteria : criterias)
            persons = criteria.meetCriteria(persons, parameters);

        if(parameters.getPage() != null){
            int firstIndex = parameters.getPage().getSize() * parameters.getPage().getPageNumber() - parameters.getPage().getSize();
            int lastIndex = parameters.getPage().getSize() * parameters.getPage().getPageNumber();
            if(lastIndex > persons.size()-1)
                lastIndex = persons.size();
            result.setPages((int) Math.ceil(persons.size()/(double)parameters.getPage().getSize()));
            persons = persons.subList(firstIndex, lastIndex);
            result.setCurrentPage(parameters.getPage().getPageNumber());
        }
        else {
            result.setCurrentPage(1);
            result.setPages(1);
        }


        result.setItems(persons);

        return result;
    }
}
