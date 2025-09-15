package library.domain;

import java.time.LocalDate;

public class LendingRecord {
    private final Book book;
    private final LocalDate borrowDate;
    private LocalDate returnDate;

    public LendingRecord(Book book, LocalDate borrowDate) {
        this.book = book;
        this.borrowDate = borrowDate;
    }

    public void markReturned(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() { return book; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getReturnDate() { return returnDate; }
}
