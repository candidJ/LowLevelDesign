package com.jaskiratmann;

import java.util.Date;
import java.util.List;

public class Book {
    private String title;
    private Date publicationDate;
    private List<Author> authors;
    private BookIdentifier bookIdentifier;
    BookFormat bookFormat;
    private int totalAvailableIssues;
    private boolean isReferenceBook;
    private String bookId;

    public int getTotalAvailableIssues() {
        return totalAvailableIssues;
    }

    public void setTotalAvailableIssues(int totalAvailableIssues) {
        this.totalAvailableIssues = totalAvailableIssues;
    }

    public boolean isReferenceBook() {
        return isReferenceBook;
    }

    public void setReferenceBook(boolean referenceBook) {
        isReferenceBook = referenceBook;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public BookIdentifier getBookIdentifier() {
        return bookIdentifier;
    }

    public void setBookIdentifier(BookIdentifier bookIdentifier) {
        this.bookIdentifier = bookIdentifier;
    }

    public BookFormat getBookFormat() {
        return bookFormat;
    }

    public void setBookFormat(BookFormat bookFormat) {
        this.bookFormat = bookFormat;
    }
}
