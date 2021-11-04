package org.example.queries.search.Filters;

import org.example.model.Person;
import org.example.queries.search.SearchParameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AndFilter implements PersonFilter{

    private PersonFilter[] filters;
    private PersonFilter filter;
    private PersonFilter otherFilter;

   /* public AndFilter(PersonFilter filter, PersonFilter otherFilter)
    {
        this.filter = filter;
        this.otherFilter = otherFilter;
    }*/

    public AndFilter(PersonFilter[] filters)
    {
        this.filters = filters;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons, SearchParameters parameters) {

        List<Person> results = filters[0].meetCriteria(persons, parameters);
        for (int i = 1; i < filters.length; i++)
        {
            results = filters[i].meetCriteria(results, parameters);
        }
        return results;
    }
   /*
    private List<Person> compareCriteria(List<Person> one, List<Person> two)
    {
        List<Person> res = one.

    }

    */
    /*
    @Override
    public List<Person> meetCriteria(List<Person> persons, SearchParameters parameters) {

        List<Person> firstCriteriaPersons = filter.meetCriteria(persons, parameters);
        return otherFilter.meetCriteria(firstCriteriaPersons, parameters);
    }*/
}
