package org.example.queries.search.Filters;

import org.example.model.Person;
import org.example.queries.search.SearchParameters;

import java.util.ArrayList;
import java.util.List;

public class AgeFilter implements PersonFilter{
    @Override
    public List<Person> meetCriteria(List<Person> persons, SearchParameters parameters) {
        List<Person> peopleWithMatchingAge = new ArrayList<Person>();

        if(parameters.getAgeFrom() != 0 && parameters.getAgeTo() != 0)
        {
            persons.stream()
                    .filter(person -> person.getAge() >= parameters.getAgeFrom() && person.getAge() <= parameters.getAgeTo()).
                    forEach(person -> peopleWithMatchingAge.add(person));
        }
        else if (parameters.getAgeFrom() != 0)
        {
            persons.stream()
                    .filter(person -> person.getAge() >= parameters.getAgeFrom()).
                    forEach(person -> peopleWithMatchingAge.add(person));
        }
        else if (parameters.getAgeTo() != 0)
        {
            persons.stream()
                    .filter(person -> person.getAge() <= parameters.getAgeTo()).
                    forEach(person -> peopleWithMatchingAge.add(person));
        }
        else
        {
            persons.stream()
                    .forEach(person -> peopleWithMatchingAge.add(person));
        }

        return peopleWithMatchingAge;
    }
}

