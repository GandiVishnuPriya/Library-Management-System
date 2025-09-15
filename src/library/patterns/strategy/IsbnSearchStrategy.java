package library.patterns.strategy;

import library.core.Inventory;
import library.domain.Book;

import java.util.ArrayList;
import java.util.List;

public class IsbnSearchStrategy implements SearchStrategy {
    @Override
    public List<Book> search(String query, Inventory inventory) {
        List<Book> results = new ArrayList<>();
        for (Inventory.BookItem item : inventory.getAllBooks()) {
            if (item.getBook().getIsbn().equals(query)) {
                results.add(item.getBook());
            }
        }
        return results;
    }
}
