package org.example.queries.search.Filters;

import org.example.model.Person;
import org.example.queries.search.SearchParameters;

import java.util.ArrayList;
import java.util.List;

public class NameFilter implements PersonFilter{
    @Override
    public List<Person> meetCriteria(List<Person> persons, SearchParameters parameters) {
        List<Person> peopleWithMatchingName = new ArrayList<Person>();

        if (parameters.getName() != null) {
            persons.stream()
                    .filter(person -> person.getName().equals(parameters.getName()))
                    .forEach(person -> peopleWithMatchingName.add(person));
        }
        else
        {
            persons.stream()
                    .forEach(person -> peopleWithMatchingName.add(person));
        }


        return peopleWithMatchingName;
    }
}
