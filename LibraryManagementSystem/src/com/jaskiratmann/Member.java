package com.jaskiratmann;

import java.time.LocalDate;
import java.util.Date;

public class Member extends Account {
    private Date membershipStartDate;
    private BookItem bookItem;
    private int totalBooksCheckedout;
    private double fineAmount;

    public int getTotalBooksCheckedout() {
        return totalBooksCheckedout;
    }

    private boolean checkForReservation(BookItem bookItem) {
        System.out.println(bookItem.toString());
        // check reservation status by delegation to BookReservation
        // TODO: implement the fetch reservation details
        // BookReservation bookReservation = BookReservation.fetchReservationDetails(bookItem.getTitle());
        if (bookItem.bookReservation.getReservationStatusEnum() == BookReservationStatusEnum.WAITING
                && bookItem.bookReservation.getMemberId() != this.getAccountId()) {
            System.out.println("Book is already reserved");
            return false;
        } else {
            this.updateBookStatus(BookStatusEnum.RESERVED);
            bookItem.bookReservation.setReservationStatusEnum(BookReservationStatusEnum.COMPLETED);
            System.out.println("Book issued with ID: " + bookItem.getBookId() + ", Title" + bookItem.getTitle());
            return true;
        }
    }

    private double collectFine(long days) {
        return this.fineAmount = days * Constant.FINE_PER_DAY;
    }

    private int updateTotalBooksCheckedoutCounter() {
        return this.totalBooksCheckedout--;
    }

    private void checkForFine() {
        Date today = new Date();
        Date dueDate = bookItem.bookLending.getDueDate();
        if (today.compareTo(dueDate) > 0) {
            long diff = dueDate.getTime() - today.getTime();
            long diffInDays = (diff / 24 * 60 * 60 * 1000);
            collectFine(diffInDays);
        }
    }

    void returnBooks() {
        this.checkForFine();
        this.updateTotalBooksCheckedoutCounter();
        if (this.bookItem.reservationStatus == BookReservationStatusEnum.WAITING) {
            this.updateBookStatus(BookStatusEnum.RESERVED);
            // send notifications
        }
        this.updateBookStatus(BookStatusEnum.AVAILABLE);
    }

    BookStatusEnum checkBookStatus(String bookId) {
        // make backend query
        return bookItem.bookStatus;
    }

    BookStatusEnum updateBookStatus(BookStatusEnum status) {
        return this.bookItem.bookStatus = status;
    }

    void checkoutBook(BookItem book) {
        if (this.getTotalBooksCheckedout() > Constant.MAXIMUM_BOOK_LIMIT_PER_MEMBER) {
            System.out.println("You have already checked out max number of books");
        }
        System.out.println(book);
        if (book.isReferenceBook()) {
            System.out.println("Reference book cannot be issued");
        }

        this.checkForReservation(book);
    }

    void renewBookItem(BookItem bookItem) {
        this.checkForFine();
        if (this.checkForReservation(bookItem)) {
            this.updateBookStatus(BookStatusEnum.RESERVED);
            this.bookItem.bookReservation.setReservationStatusEnum(BookReservationStatusEnum.COMPLETED);
            System.out.println("Book" + bookItem.getBookId() + " Named" + bookItem.getTitle() + "is already reserved");

        } else {
            this.bookItem.bookLending.lendBook(this.bookItem.getBookId());
            LocalDate newDueDate = LocalDate.now().plusDays(Constant.MAXIMUM_LOAN_DAYS_PER_BOOK);
            System.out
                    .println("Book with Title" + bookItem.getTitle() + "is renewed. The new Due date is" + newDueDate);
            // this.bookItem.bookLending.updateDueDate(LocalDate.now().plusDays(Constant.MAXIMUM_LOAN_DAYS_PER_BOOK));
        }

    }
}
