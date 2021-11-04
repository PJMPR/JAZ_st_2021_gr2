package org.example.queries.setters;

import org.example.model.Person;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.ArrayList;

public class SetPeopleOnPage {
    public static void setPeopleOnPage(Results result, SearchParameters parameters) {
        if(parameters.getPage() != null) {
            int pageSize = parameters.getPage().getSize();
            int pageNumber = result.getCurrentPage();
            ArrayList<Person> people = new ArrayList<>();

            int nextPerson = 0;
            if (pageNumber > 1){
                nextPerson = (pageSize * (pageNumber - 1)) + 1;
            }

            for (int i = 0; i < pageSize; i++) {
                people.add(result.getItems().get(nextPerson++));
                if(nextPerson == result.getItems().size()){
                    break;
                }
            }
            result.setItems(people);
        }
    }
}
