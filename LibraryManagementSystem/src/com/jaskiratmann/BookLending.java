package com.jaskiratmann;

import java.util.Date;

public class BookLending {
    private Date dueDate;
    private Date returnDate;
    private String memberId;

    public void lendBook(String memberId) {
    }

    public void updateDueDate(Date newDate) {
        this.dueDate = newDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

}
