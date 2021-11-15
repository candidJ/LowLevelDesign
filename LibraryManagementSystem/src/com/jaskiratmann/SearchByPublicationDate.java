package com.jaskiratmann;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class SearchByPublicationDate implements Search {
    HashMap<String, List<Book>> bookPublicationDates;

    @Override
    public <Date> List<Book> performSearch(Date query) {
        return this.bookPublicationDates.get(query);
    }
}
