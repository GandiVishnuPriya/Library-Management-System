# Library-Management-System
Book.java → Concrete class
Fields (instances):

String title

String author

String isbn

int publicationYear

Methods:

Getters/Setters (getTitle(), setTitle(), etc.)

toString()

Patron.java → Concrete class
Fields:

String id

String name

List<LendingRecord> history

Methods:

addRecord(LendingRecord record)

Getters/Setters

toString()

LendingRecord.java → Concrete class
Fields:

Book book

LocalDate checkoutDate

LocalDate returnDate

Methods:

markReturned(LocalDate date)

Getters/Setters

core package
Inventory.java → Concrete class
Inner Class:

BookItem (manages Book and count of copies)

Fields:

Map<String, BookItem> books

List<InventoryObserver> observers

Methods:

addBook(Book book, int copies)

removeBook(String isbn)

checkoutBook(String isbn)

returnBook(String isbn)

notifyObservers(Book book)

Library.java → Concrete class
Fields:

Inventory inventory

Map<String, Patron> patrons

Methods:

addPatron(Patron patron)

updatePatron(Patron patron)

checkoutBook(String patronId, String isbn)

returnBook(String patronId, String isbn)

searchBooks(SearchStrategy strategy, String query)

patterns package
observer/InventoryObserver.java → Interface
Methods:

void onLowStock(Book book, int availableCopies)

observer/LowStockNotifier.java → Concrete class
Implements: InventoryObserver

Methods:

onLowStock(Book book, int availableCopies) (logs a warning)

strategy/SearchStrategy.java → Interface
Methods:

List<Book> search(String query, Inventory inventory)

strategy/TitleSearchStrategy.java → Concrete class
Implements: SearchStrategy

Methods:

search(String query, Inventory inventory) → search by title

strategy/AuthorSearchStrategy.java → Concrete class
Implements: SearchStrategy

Methods:

search(String query, Inventory inventory) → search by author

strategy/IsbnSearchStrategy.java → Concrete class
Implements: SearchStrategy

Methods:

search(String query, Inventory inventory) → search by ISBN

factory/EntityFactory.java → Concrete class (Factory Pattern)
Methods (static):

Book createBook(String title, String author, String isbn, int year)

Patron createPatron(String id, String name)

Main Runner
LibraryManagementSystem.java → Concrete class
Methods:

public static void main(String[] args) → runs demo

Inside main:

Creates Inventory, Library, Patrons using EntityFactory

Adds books, registers observers

Calls checkoutBook, returnBook

Demonstrates searchBooks with different SearchStrategy
Demonstrates searchBooks with different SearchStrategy
