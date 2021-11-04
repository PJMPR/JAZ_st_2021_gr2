package org.example.queries.search.Filters;

import org.example.model.Person;
import org.example.queries.search.SearchParameters;

import java.util.ArrayList;
import java.util.List;

public class SurnameFilter implements PersonFilter{
    @Override
    public List<Person> meetCriteria(List<Person> persons, SearchParameters parameters) {
        List<Person> peopleWithMatchingSurname = new ArrayList<Person>();

        if (parameters.getSurname() != null) {
            persons.stream()
                    .filter(person -> person.getSurname().equals(parameters.getSurname()))
                    .forEach(person -> peopleWithMatchingSurname.add(person));
        }
        else
        {
            persons.stream()
                    .forEach(person -> peopleWithMatchingSurname.add(person));
        }

        return peopleWithMatchingSurname;
    }
}
