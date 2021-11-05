package org.example.queries.criteria;
import org.example.model.Person;
import org.example.queries.search.SearchParameters;
import java.util.List;
import java.util.stream.Collectors;

public class Name implements Criteria{
    @Override
    public List<Person> meetCriteria(List<Person> persons, SearchParameters parameters) {
        return parameters.getName() != null ?
                persons.stream().filter(person -> person.getName().equalsIgnoreCase(parameters.getName())).collect(Collectors.toList()) :
                persons;
    }
}
