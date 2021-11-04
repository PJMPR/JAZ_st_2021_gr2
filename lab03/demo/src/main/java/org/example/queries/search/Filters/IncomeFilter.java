package org.example.queries.search.Filters;

import org.example.model.Person;
import org.example.queries.search.SearchParameters;

import java.util.ArrayList;
import java.util.List;

public class IncomeFilter implements PersonFilter{
    @Override
    public List<Person> meetCriteria(List<Person> persons, SearchParameters parameters) {
        List<Person> peopleWithMatchingIncome = new ArrayList<Person>();

        if(parameters.getIncomeFrom() != 0 && parameters.getIncomeTo() != 0)
        {
            persons.stream()
                    .filter(person -> person.getIncome() >= parameters.getIncomeFrom() && person.getIncome() <= parameters.getIncomeTo()).
                    forEach(person -> peopleWithMatchingIncome.add(person));
        }
        else if (parameters.getIncomeFrom() != 0)
        {
            persons.stream()
                    .filter(person -> person.getIncome() >= parameters.getIncomeFrom()).
                    forEach(person -> peopleWithMatchingIncome.add(person));
        }
        else if (parameters.getIncomeTo() != 0)
        {
            persons.stream()
                    .filter(person -> person.getIncome() <= parameters.getIncomeTo()).
                    forEach(person -> peopleWithMatchingIncome.add(person));
        }
        else
        {
            return persons;
        }

        return peopleWithMatchingIncome;
    }
}
