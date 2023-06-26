package ejercicio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BookStore {
    Map<String, List<Book>> booksBySpecialty;
    Map<String, Book> booksByAuthor;

    public BookStore() {
        booksBySpecialty = new HashMap<>();
        booksByAuthor = new HashMap<>();
    }

    public void addBook(Book book) {
        List<Book> books = booksBySpecialty.getOrDefault(book.specialty, new ArrayList<>());
        books.add(book);
        booksBySpecialty.put(book.specialty, books);
        booksByAuthor.put(book.author, book);
    }

    public void modifyBook(Book newBook) {
        Book existingBook = booksByAuthor.get(newBook.author);
        if (existingBook == null) {
            addBook(newBook);
        } else {
            existingBook.title = newBook.title;
            existingBook.sales = newBook.sales;
            existingBook.criticRating = newBook.criticRating;
            existingBook.comments = newBook.comments;
        }
    }

    public Book getBookWithBestRatingByAuthor(String author) {
        return booksByAuthor.get(author);
    }

    public List<Book> getBooksBySpecialtyOrderedBySales(String specialty) {
        List<Book> books = booksBySpecialty.getOrDefault(specialty, new ArrayList<>());
        Collections.sort(books, (b1, b2) -> Integer.compare(b2.sales, b1.sales));
        return books;
    }
}

