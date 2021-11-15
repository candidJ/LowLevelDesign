package com.jaskiratmann;

import java.util.HashMap;
import java.util.List;

public class SearchByTitle implements Search {

    HashMap<String, List<Book>> bookTitles;

    @Override
    public <String> List<Book> performSearch(String query) {
        return bookTitles.get(query);
    }
}
