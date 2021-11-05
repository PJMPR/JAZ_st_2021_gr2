package org.example.queries;

import org.example.model.People;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

public class QueryProcessor2 {

    public static Results GetResults(SearchParameters parameters){
        Results result = new Results();
        //People people = new People();
        result.setItems(People.Data);
        People.Data.stream()
                //.filter(person->person.getName()==parameters.getName())
                //.filter(person -> person.getSurname()==parameters.getSurname())
                .filter(person -> (person.getAge()>=parameters.getAgeFrom()) && (person.getAge()<=parameters.getAgeTo()))
                .filter(person -> (person.getIncome()>=parameters.getIncomeFrom()) && (person.getIncome()<=parameters.getIncomeTo()))
                .forEach(person->{
                    result.getItems().add(person);
                })
        ;

        return result;
    }
}
