package org.example.queries;

import org.example.basics.*;
import org.example.functions.IncomeAgeMethods;
import org.example.model.People;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.List;

public class QueryProcessor {
    List<BasicInterface> BasicsInterfaceList = List.of(
            new SurnameBasics(),
            new ToAgeBasics(),
            new ToIncomeBasics(),
            new PageBasics(),
            new FromAgeBasics(),
            new FromIncomeBasics(),
            new GenderBasics(),
            new NameBasics()
    );
    public Results GetResults(SearchParameters parameters){
        Results result = new Results();

        IncomeAgeMethods function = new IncomeAgeMethods();
        result.setItems(People.Data);

        BasicsInterfaceList.forEach(filter -> filter.useBasicInterface(result, parameters));

        function.ageIncomeFunction(parameters, result);


        return result;
    }
}
