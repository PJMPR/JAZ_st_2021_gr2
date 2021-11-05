package org.example.queries.criteria;
import org.example.model.Person;
import org.example.queries.search.SearchParameters;
import java.util.List;
import java.util.stream.Collectors;

public class Gender implements Criteria{
    @Override
    public List<Person> meetCriteria(List<Person> persons, SearchParameters parameters) {
        return  !parameters.getSelectedGenders().isEmpty() ? persons.stream().filter(person -> parameters.getSelectedGenders().contains(person.getGender())).collect(Collectors.toList()) : persons;
    }
}
