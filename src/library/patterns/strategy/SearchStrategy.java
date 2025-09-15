package library.patterns.strategy;

import library.core.Inventory;
import library.domain.Book;
import java.util.List;

public interface SearchStrategy {
    List<Book> search(String query, Inventory inventory);
}
