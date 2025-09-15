package library.patterns.observer;

import library.domain.Book;

public interface InventoryObserver {
    void onLowStock(Book book, int availableCopies);
}
