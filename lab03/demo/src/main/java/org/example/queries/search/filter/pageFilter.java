package org.example.queries.search.filter;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.stream.Collectors;

public class pageFilter implements Filter{

    @Override
    public void useFilter(Results results, SearchParameters searchParameters) {
        if(searchParameters.getPage()!=null){
            results.setPages(numberOfPages(results,searchParameters));
            results.setCurrentPage(searchParameters.getPage().getPageNumber());
            results.setItems((
                    results.getItems()
                            .stream()
                            .skip(skippedElements(results,searchParameters))
                            .limit(searchParameters.getPage().getSize()).collect(Collectors.toList())));
        }
    }
    private int numberOfPages(Results results, SearchParameters searchParameters){
        if(searchParameters.getPage().getSize()<results.getItems().size()){
            int div=results.getItems().size()/searchParameters.getPage().getSize();
            if(results.getItems().size()%searchParameters.getPage().getSize()!=0){
                return div+1;
            }
            else {
                return div;
            }
        }return 1;
    }
    private int skippedElements(Results results, SearchParameters searchParameters){
        return (results.getCurrentPage()-1)*searchParameters.getPage().getSize();
    }
}
