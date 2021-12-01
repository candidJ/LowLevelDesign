package com.jaskiratmann;

import java.util.Date;
import java.util.List;

public class BookReservation {
    protected Date reservationDate;
    private String memberId;
    private String bookItemBarcode;
    private BookReservationStatusEnum reservationStatusEnum;

    public BookReservationStatusEnum updateReservationStatus(BookReservationStatusEnum bookReservationStatus) {
        return this.reservationStatusEnum = bookReservationStatus;
    }

    // public static BookReservation fetchReservationDetails(String bookTitle) {
   
    //     // return bookItem;
    // }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getBookItemBarcode() {
        return bookItemBarcode;
    }

    public void setBookItemBarcode(String bookItemBarcode) {
        this.bookItemBarcode = bookItemBarcode;
    }

    public BookReservationStatusEnum getReservationStatusEnum() {
        return reservationStatusEnum;
    }

    public void setReservationStatusEnum(BookReservationStatusEnum reservationStatusEnum) {
        this.reservationStatusEnum = reservationStatusEnum;
    }
}
