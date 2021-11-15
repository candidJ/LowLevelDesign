package com.jaskiratmann;

import java.util.List;

public class Catalog {
    Search search;

    void setSearchStrategy(Search search) {
        this.search = search;
    }

    <T> List<Book> performSearch(T query) {
        return this.search.performSearch(query);
    }

}
