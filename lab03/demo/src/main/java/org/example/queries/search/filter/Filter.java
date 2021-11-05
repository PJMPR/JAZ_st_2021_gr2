package org.example.queries.search.filter;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

public interface Filter {
    void useFilter(Results results, SearchParameters searchParameters);
}
