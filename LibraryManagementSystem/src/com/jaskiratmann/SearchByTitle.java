package com.jaskiratmann;

import java.util.ArrayList;
import java.util.List;

public class SearchByTitle extends Catalog implements Search {

    @Override
    public <String> List<Book> performSearch(String query) {
        BookItem book = this.getBooksCatalog().get(query);
        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        return bookList;
    }
}
