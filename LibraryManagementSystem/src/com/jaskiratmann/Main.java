package com.jaskiratmann;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Library Main Class");

        // first book item
        BookItem thePragmaticProgrammerBookItem = new BookItem();
        thePragmaticProgrammerBookItem.setBookId("1");
        thePragmaticProgrammerBookItem.setTitle("The Pragmatic Programmer");
        thePragmaticProgrammerBookItem.setReferenceBook(false);
        thePragmaticProgrammerBookItem.setBookFormat(BookFormat.HARDCOVER);
        ArrayList<Author> authorsForThePragmaticProgrammer = new ArrayList<Author>();
        authorsForThePragmaticProgrammer.add(new Author("Andrew Hunt", 1));
        authorsForThePragmaticProgrammer.add(new Author("David Thomas", 2));
        thePragmaticProgrammerBookItem.setAuthors(authorsForThePragmaticProgrammer);

        // second book item
        BookItem grokkingAlgoBookItem = new BookItem();
        grokkingAlgoBookItem.setBookId("2");
        grokkingAlgoBookItem.setTitle("Grokking Algorithms");
        grokkingAlgoBookItem.setReferenceBook(true);
        grokkingAlgoBookItem.setBookFormat(BookFormat.PAPERBACK);
        ArrayList<Author> authorForGrokkingAlgoBookItem = new ArrayList<Author>();
        authorForGrokkingAlgoBookItem.add(new Author("Bhargava", 3));
        grokkingAlgoBookItem.setAuthors(authorForGrokkingAlgoBookItem);
        // grokkingAlgoBookItem.setRe

        Catalog libraryCatalog = new Catalog();
        libraryCatalog.addBookItem(thePragmaticProgrammerBookItem);
        libraryCatalog.addBookItem(grokkingAlgoBookItem);

        Search searchByBookTitle = new SearchByTitle();
        Catalog catalog = new Catalog();
        catalog.setSearchStrategy(searchByBookTitle);
        List<Book> bookItem = catalog.performSearch(thePragmaticProgrammerBookItem.getTitle());
        System.out.println("Search result" + bookItem);
        // Member jaskiratLibraryMember = new Member();
        // jaskiratLibraryMember.checkoutBook(thePragmaticProgrammerBookItem);
    }
}
