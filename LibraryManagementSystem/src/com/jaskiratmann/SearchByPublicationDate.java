package com.jaskiratmann;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SearchByPublicationDate extends Catalog implements Search {

    @Override
    public <Date> List<Book> performSearch(Date query) {
        BookItem book = this.getBooksCatalog().get(query);
        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        return bookList;
    }
}
