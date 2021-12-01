package com.jaskiratmann;

import java.util.HashMap;
import java.util.List;

public class Catalog {
    Search search;

    private HashMap<String, BookItem> booksCatalog;

    public HashMap<String, BookItem> getBooksCatalog() {
        return booksCatalog;
    }

    public void setBooksCatalog(HashMap<String, BookItem> booksCatalog) {
        this.booksCatalog = booksCatalog;
    }

    public Catalog() {
        booksCatalog = new HashMap<String, BookItem>();
    }

    void setSearchStrategy(Search search) {
        this.search = search;
    }

    <T> List<Book> performSearch(T query) {
        return this.search.performSearch(query);
    }

    boolean addBookItem(BookItem bookItem) {
        if (booksCatalog.containsKey(bookItem.getBookId())) {
            System.out.println("Book already added to Catalog" + bookItem.getTitle());
            return false;
        }

        booksCatalog.put(bookItem.getBookId(), bookItem);
        System.out.println("Added " + bookItem.getTitle() + " to the catalog succesfully");
        return true;
    }

    boolean removeBookItem(String bookItemId) {
        if (!this.booksCatalog.containsKey(bookItemId)) {
            return false;
        }
        ;
        this.booksCatalog.remove(bookItemId);
        System.out.println("Book with ID" + bookItemId + "is removed from the system");
        return true;
    }

}
