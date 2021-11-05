package org.example.queries.criteria;
import org.example.model.Person;
import org.example.queries.search.SearchParameters;
import java.util.List;
import java.util.stream.Collectors;

public class Surname implements Criteria{
    @Override
    public List<Person> meetCriteria(List<Person> persons, SearchParameters parameters) {
        return parameters.getSurname() != null ?
                persons.stream().filter(person -> person.getSurname().equalsIgnoreCase(parameters.getSurname())).collect(Collectors.toList()) :
                persons;
    }
}
