package org.example.queries.criteria;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.stream.Collectors;

public class PageCriteria implements Criteria{

    @Override
    public void meetCriteria(Results results, SearchParameters searchParameters) {
        if(searchParameters.getPage() != null){
            results.setPages(pagesAmount(results,searchParameters));
            results.setCurrentPage(searchParameters.getPage().getPageNumber());
            results.setItems(
                    results
                            .getItems()
                            .stream()
                            .skip(filteredElements(results, searchParameters))
                            .limit(searchParameters.getPage().getSize())
                            .collect(Collectors.toList()));
        }
    }

    private int pagesAmount(Results results, SearchParameters searchParameters){
        int resultsSize = results.getItems().size();
        int pageElementsNum = searchParameters.getPage().getSize();

        int result = resultsSize/pageElementsNum+1;

        return result;
    }

    private int filteredElements(Results results, SearchParameters searchParameters){
        int pageNum = results.getCurrentPage();
        int pageElementsNum = searchParameters.getPage().getSize();

        int result = (pageNum -1) * pageElementsNum;

        return result;

    }


}
