package org.example.queries.search.Filters;

import org.example.model.Person;
import org.example.queries.search.SearchParameters;

import java.util.ArrayList;
import java.util.List;

public class GenderFilter implements PersonFilter{
    @Override
    public List<Person> meetCriteria(List<Person> persons, SearchParameters params) {
        List<Person> peopleWithMatchingGender = new ArrayList<Person>();
        if (!params.getSelectedGenders().isEmpty()) {
            persons.stream()
                    .filter(person -> params.getSelectedGenders().contains(person.getGender()))
                    .forEach(person -> peopleWithMatchingGender.add(person));
        }
        else
        {
            persons.stream()
                    .forEach(person -> peopleWithMatchingGender.add(person));
        }
        return peopleWithMatchingGender;
    }
}
