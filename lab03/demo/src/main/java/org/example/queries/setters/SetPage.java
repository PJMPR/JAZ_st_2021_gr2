package org.example.queries.setters;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

public class SetPage {
    public static void setPages(Results result, SearchParameters parameters) {
        if(parameters.getPage() != null){
            int pageSize = parameters.getPage().getSize();
            int pageNumber = parameters.getPage().getPageNumber();
            result.setCurrentPage(pageNumber);
            result.setPages((result.getItems().size()/pageSize)+1);
        }
    }
}
