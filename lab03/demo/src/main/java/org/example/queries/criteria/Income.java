package org.example.queries.criteria;
import org.example.model.Person;
import org.example.queries.search.SearchParameters;
import java.util.List;
import java.util.stream.Collectors;

public class Income implements Criteria{
    @Override
    public List<Person> meetCriteria(List<Person> persons, SearchParameters parameters) {
        return persons.stream().filter(person -> person.getIncome() >= parameters.getIncomeFrom() && person.getIncome() <= parameters.getIncomeTo()).collect(Collectors.toList());

    }
}
