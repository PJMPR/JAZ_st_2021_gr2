package org.example.queries.criterias;

import org.example.model.Person;
import org.example.queries.search.SearchParameters;
import java.util.List;

public interface Criteria {

    public List<Person> meetCriteria(List<Person> persons, SearchParameters searchParameters);

    public boolean isSet(SearchParameters searchParameters);
}