package org.example.queries;

import org.example.model.Person;
import org.example.model.People;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;
import java.util.ArrayList;
import org.example.queries.search.Funcs;
import org.example.queries.search.FunctionsParameters;
import org.example.queries.search.Page;
import org.example.model.Gender;
import org.example.model.People;
import org.example.queries.QueryProcessor;
import org.example.queries.results.Results;
import org.example.queries.results.FunctionResult;
import org.example.queries.search.FunctionsParameters;
import org.example.queries.search.Page;
import org.example.queries.search.SearchParameters;
import java.util.List;
import java.util.stream.Collectors;

public class QueryProcessor {

    public static Results GetResults(SearchParameters parameters){
        Results result = new Results();
        result.setItems(People.Data);
        List<Person>  sampleResult = new ArrayList<>();
        List<FunctionResult> functions = new ArrayList<>();
        result.getItems().stream()
                //.filter(person -> ((person.getName() == parameters.getName()) || (parameters.getName() == ""))
                //.filter(person -> ((person.getSurname() == parameters.getSurname()) || (parameters.getSurname() == ""))
                .filter(person -> ((person.getAge() >= parameters.getAgeFrom()) && (person.getAge() <= parameters.getAgeTo())))
                .filter(person ->person.getIncome() >= parameters.getIncomeFrom())
                .filter(person ->parameters.getSelectedGenders().contains(person.getGender()))
        .forEach(person -> {
            sampleResult.add(person);
            System.out.println(person.getName() + " " + person.getSurname() + " " + person.getAge());});
        result.setItems(sampleResult);
        double avarage = result.getItems().stream()
                .collect(Collectors.averagingInt(person -> (person.getAge())));
        System.out.println("Srednia wieku: " + avarage);
        double sum = result.getItems().stream()
                .collect(Collectors.summingDouble(person -> (person.getIncome())));
        System.out.println("Suma zarobkow " + sum);
        double avarageSum = result.getItems().stream()
                .collect(Collectors.averagingDouble(person -> (person.getIncome())));
        System.out.println("Srednia zarobkow: " + avarageSum);
        functions.add(new FunctionResult(Funcs.AVARAGE, "age", avarage));
        functions.add(new FunctionResult(Funcs.SUM, "income", sum));
        functions.add(new FunctionResult(Funcs.AVARAGE, "income", avarageSum));
        result.setFunctionResults(functions);
        if (parameters.getPage().getSize() > 0) {
            if (result.getItems().size() % parameters.getPage().getSize() == 0) {
                result.setPages(result.getItems().size()/parameters.getPage().getSize());
                result.setCurrentPage(result.getPages() + 1);
            } else {
                result.setPages(result.getItems().size()/parameters.getPage().getSize() + 1);
                result.setCurrentPage(result.getPages());
            }
        } else {
            result.setPages(0);
            result.setCurrentPage(0);
        }
        return result;
    }
}
