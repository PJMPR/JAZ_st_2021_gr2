package org.example.queries.criteria;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;
import java.util.stream.Collectors;

public class IncomeCriteria implements Criteria{
    @Override
    public void meetCriteria(Results results, SearchParameters searchParameters) {
        if(searchParameters.getIncomeFrom()>0){results.setItems(

            results
                    .getItems()
                    .stream()
                    .filter(person -> person.getIncome() >= searchParameters.getIncomeFrom())
                    .collect(Collectors.toList()
                    ));

        }

        if(searchParameters.getIncomeTo()>0){results.setItems(

            results
                    .getItems()
                    .stream()
                    .filter(person -> person.getIncome() <= searchParameters.getIncomeTo())
                    .collect(Collectors.toList()
                    ));
        }
    }
}
