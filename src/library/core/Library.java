package library.core;

import library.domain.*;
import library.patterns.strategy.SearchStrategy;

import java.time.LocalDate;
import java.util.*;

public class Library {
    private final Map<String, Patron> patrons = new HashMap<>();
    private final Inventory inventory;

    public Library(Inventory inventory) {
        this.inventory = inventory;
    }

    public void registerPatron(Patron patron) {
        patrons.put(patron.getId(), patron);
    }

    public boolean checkoutBook(String patronId, String isbn) {
        Patron patron = patrons.get(patronId);
        Book book = inventory.checkout(isbn);
        if (patron != null && book != null) {
            patron.addRecord(new LendingRecord(book, LocalDate.now()));
            return true;
        }
        return false;
    }

    public boolean returnBook(String patronId, String isbn) {
        Patron patron = patrons.get(patronId);
        if (patron != null) {
            for (LendingRecord record : patron.getHistory()) {
                if (record.getBook().getIsbn().equals(isbn) && record.getReturnDate() == null) {
                    record.markReturned(LocalDate.now());
                    inventory.checkin(isbn);
                    return true;
                }
            }
        }
        return false;
    }

    public List<Book> searchBooks(SearchStrategy strategy, String query) {
        return strategy.search(query, inventory);
    }
}
