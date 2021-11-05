package org.example.filters;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.stream.Collectors;

public class FilterPage implements Filter {
    @Override
    public void meetCriteria(Results results, SearchParameters searchParameters) {
        if (searchParameters.getPage() != null) {

            results.setPages(calculatePages(results, searchParameters));
            results.setCurrentPage(searchParameters.getPage().getPageNumber());

            results.setItems(results.getItems().stream()
                    .skip(calculateElementsToSkip(results, searchParameters))
                    .limit(searchParameters.getPage().getSize())
                    .collect(Collectors.toList()));
        }
    }

    public int calculateElementsToSkip(Results results, SearchParameters searchParameters) {
        int numOfPages = results.getCurrentPage();
        int numOfElementsOnPage = searchParameters.getPage().getSize();

        return (numOfPages - 1) * numOfElementsOnPage;
    }

    public int calculatePages(Results result, SearchParameters searchParameters) {
        int numOfElements = result.getItems().size();
        int maxElementsOnPage = searchParameters.getPage().getSize();

        if (maxElementsOnPage < numOfElements) {
            if (numOfElements % maxElementsOnPage != 0) {
                return numOfElements / maxElementsOnPage + 1;
            } else {
                return numOfElements / maxElementsOnPage;
            }
        }
        return 1;
    }
}
