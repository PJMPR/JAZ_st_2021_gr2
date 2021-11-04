package org.example.queries.search.Filters;

import org.example.model.Person;
import org.example.queries.search.SearchParameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PageFilter implements PersonFilter{
    @Override
    public List<Person> meetCriteria(List<Person> persons, SearchParameters parameters) {
        List<Person> peopleWithMatchingPage = new ArrayList<Person>();
        Person[] people = new Person[persons.size()];
        persons.toArray(people);
        int inedx = 0;
        if (parameters.getPage() != null)
        {
            Person[] matchingPeople = new Person[parameters.getPage().getSize()];

            for (int page = 1; page <= parameters.getPage().getPageNumber(); page++)
            {
                for (int size = 0; size < parameters.getPage().getSize(); size++)
                {
                    if (page == parameters.getPage().getPageNumber())
                    {
                        matchingPeople[size] = people[inedx];
                    }
                    inedx++;
                }
            }

            peopleWithMatchingPage = Arrays.asList(matchingPeople);
         // persons.stream()
         //          .filter(person -> "==========" == parameters.getPage().getSize())
        }
        else
        {
            return persons;
        }
        return peopleWithMatchingPage;
    }
}
