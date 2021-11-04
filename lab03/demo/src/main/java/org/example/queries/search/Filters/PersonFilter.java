package org.example.queries.search.Filters;

import org.example.model.Person;
import org.example.queries.search.SearchParameters;

import java.util.List;

public interface PersonFilter {
    public List<Person> meetCriteria(List<Person> persons, SearchParameters parameters);
}
