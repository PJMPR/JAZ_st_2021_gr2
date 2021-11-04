package org.example.queries.AllFilters;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;
import java.util.stream.Collectors;

public class PagingFilter implements Filter{
    @Override
    public void meetCriteria(Results results, SearchParameters searchParameters) {
        if (searchParameters.getPage() != null) {

            results.setPages(calculateNumberOfPages(results, searchParameters));
            results.setCurrentPage(searchParameters.getPage().getPageNumber());

            results.setItems(results.getItems().stream()
                    .skip(calculateElementsToSkip(results, searchParameters))
                    .limit(searchParameters.getPage().getSize())
                    .collect(Collectors.toList()));
        }
    }

    public int calculateNumberOfPages(Results result, SearchParameters searchParameters) {
        int numberOfElements = result.getItems().size();
        int maxElementsOnPage = searchParameters.getPage().getSize();

        if (maxElementsOnPage < numberOfElements) {
            if (numberOfElements % maxElementsOnPage != 0) {
                return numberOfElements / maxElementsOnPage + 1;
            } else {
                return numberOfElements / maxElementsOnPage;
            }
        }
        return 1;
    }

    public int calculateElementsToSkip(Results results, SearchParameters searchParameters) {
        int numberOfPages = results.getCurrentPage();
        int numberOfElementsOnPage = searchParameters.getPage().getSize();

        return (numberOfPages - 1) * numberOfElementsOnPage;
    }
}
