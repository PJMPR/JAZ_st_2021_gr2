package org.example.queries;

import org.example.model.Gender;
import org.example.model.People;
import org.example.model.Person;
import org.example.queries.results.Results;
import org.example.queries.search.FunctionSetter;
import org.example.queries.search.SearchParameters;
import org.example.queries.setters.SetPage;
import org.example.queries.setters.SetPeopleOnPage;

import java.util.*;
import java.util.stream.Collectors;

public class QueryProcessor {

    public Results GetResults(SearchParameters parameters){
        Results result = new Results();

        setPeople(result, parameters);
        SetPage.setPages(result, parameters);
        SetPeopleOnPage.setPeopleOnPage(result, parameters);
        FunctionSetter.setFunctions(result, parameters);

        return result;
    }

    private void setPeople(Results result, SearchParameters parameters) {
        List<Person> list = People.Data;

        if(parameters.getName() != null){
            list = list.stream()
                    .filter(person -> person.getName()
                            .equals(parameters.getName()
                                    .toLowerCase(Locale.ROOT)))
                    .collect(Collectors.toList());
        }
        if(parameters.getSurname() != null){
            list = list.stream()
                    .filter(person -> person.getSurname()
                            .equals(parameters.getSurname()
                                    .toLowerCase(Locale.ROOT)))
                    .collect(Collectors.toList());
        }
        if(parameters.getAgeFrom() != 0){
            list = list.stream()
                    .filter(person -> person.getAge()>=parameters
                            .getAgeFrom())
                    .collect(Collectors.toList());
        }
        if(parameters.getAgeTo() != 0){
            list = list.stream()
                    .filter(person -> person.getAge()<=parameters
                            .getAgeTo())
                    .collect(Collectors.toList());
        }
        if(parameters.getIncomeFrom() != 0){
            list = list.stream()
                    .filter(person -> person.getIncome()>=parameters
                            .getIncomeFrom())
                    .collect(Collectors.toList());
        }
        if(parameters.getIncomeTo() != 0){
            list = list.stream()
                    .filter(person -> person.getIncome()<=parameters
                            .getIncomeTo())
                    .collect(Collectors.toList());
        }

        List<Gender> selectedGenders = parameters.getSelectedGenders();

        if(selectedGenders.size() == 2){
            list = list.stream()
                    .filter(person -> person.getGender()==selectedGenders
                            .get(0) || person.getGender()==selectedGenders.get(1))
                    .collect(Collectors.toList());
        }else if(selectedGenders.size() == 1){
            list = list.stream()
                    .filter(person -> person.getGender()==selectedGenders
                            .get(0))
                    .collect(Collectors.toList());
        }
        result.setItems(list);
    }
}