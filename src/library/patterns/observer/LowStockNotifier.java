package library.patterns.observer;

import library.domain.Book;

public class LowStockNotifier implements InventoryObserver {
    @Override
    public void onLowStock(Book book, int availableCopies) {
        System.out.println("Low stock for " + book.getTitle() + ": " + availableCopies);
    }
}
