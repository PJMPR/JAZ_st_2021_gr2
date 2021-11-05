package org.example.filters;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.stream.Collectors;

public class PageFilter implements FilterInterface {


    private int countNumberOfPages(Results results, SearchParameters searchParameters){
        int elementsOnPage = results.getItems().size();
        int maxElementsOnPage = searchParameters.getPage().getSize();

        if (maxElementsOnPage < elementsOnPage) {
            if (elementsOnPage % maxElementsOnPage != 0) {
                return elementsOnPage / maxElementsOnPage + 1;
            } else {
                return elementsOnPage / maxElementsOnPage;
            }
        }
        return 1;
    }

    private int countElementsToSkip(Results results, SearchParameters searchParameters){
        return (results.getCurrentPage() - 1) * searchParameters.getPage().getSize();
    }


    @Override
    public void meetCriteria(Results results, SearchParameters searchParameters) {
        if (searchParameters.getPage() != null) {
            results.setPages(countNumberOfPages(results, searchParameters));
            results.setCurrentPage(searchParameters.getPage().getPageNumber());

            results.setItems(results.getItems().stream()
                    .skip(countElementsToSkip(results, searchParameters))
                    .limit(searchParameters.getPage().getSize())
                    .collect(Collectors.toList()));
        }
    }

}
