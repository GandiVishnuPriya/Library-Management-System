package library.core;

import library.domain.Book;
import library.patterns.observer.InventoryObserver;

import java.util.*;

public class Inventory {
    private final Map<String, BookItem> books = new HashMap<>();
    private final List<InventoryObserver> observers = new ArrayList<>();

    public void addObserver(InventoryObserver observer) {
        observers.add(observer);
    }

    public void addBook(Book book, int copies) {
        books.put(book.getIsbn(), new BookItem(book, copies));
    }

    public void removeBook(String isbn) {
        books.remove(isbn);
    }

    public Book checkout(String isbn) {
        BookItem item = books.get(isbn);
        if (item != null && item.availableCopies > 0) {
            item.availableCopies--;
            if (item.availableCopies <= 1) {
                notifyObservers(item.book, item.availableCopies);
            }
            return item.book;
        }
        return null;
    }

    public void checkin(String isbn) {
        BookItem item = books.get(isbn);
        if (item != null) item.availableCopies++;
    }

    public Collection<BookItem> getAllBooks() { return books.values(); }

    private void notifyObservers(Book book, int availableCopies) {
        for (InventoryObserver obs : observers) {
            obs.onLowStock(book, availableCopies);
        }
    }


    public static class BookItem {
        private final Book book;
        private int availableCopies;

        public BookItem(Book book, int copies) {
            this.book = book;
            this.availableCopies = copies;
        }

        public Book getBook() { return book; }
        public int getAvailableCopies() { return availableCopies; }
    }
}
