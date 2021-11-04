package org.example.queries.AllFilters;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

public interface Filter {
    void meetCriteria (Results results, SearchParameters searchParameters);

}