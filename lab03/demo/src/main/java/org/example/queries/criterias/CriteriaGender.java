package org.example.queries.criterias;

import org.example.model.Person;
import org.example.queries.search.SearchParameters;

import java.util.List;
import java.util.stream.Collectors;

public class CriteriaGender implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons, SearchParameters searchParameters) {
        if(isSet(searchParameters)) {
            return persons.stream()
                    .filter(person -> (searchParameters.getSelectedGenders()).contains(person.getGender()))
                    .collect(Collectors.toList());
        }
        else {
            return persons;
        }
    }

    @Override
    public boolean isSet(SearchParameters searchParameters) {
        return !searchParameters.getSelectedGenders().isEmpty();
    }
}
