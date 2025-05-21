package com.example.library;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    @Test
    public void testAddBook() {
        Library library = new Library();
        Book book = new Book("1984", "George Orwell", 1949);
        library.addBook(book);
        assertEquals(1, library.getBooks().size());
    }

    @Test
    public void testRemoveBook() {
        Library library = new Library();
        library.addBook(new Book("1984", "George Orwell", 1949));
        boolean removed = library.removeBook("1984");
        assertTrue(removed);
        assertEquals(0, library.getBooks().size());
    }

    @Test
    public void testFindBook() {
        Library library = new Library();
        Book book = new Book("Dune", "Frank Herbert", 1965);
        library.addBook(book);
        assertNotNull(library.findBook("dune"));
    }

    @Test
    public void testGetBooks() {
        Library library = new Library();
        library.addBook(new Book("Dune", "Frank Herbert", 1965));
        List<Book> books = library.getBooks();
        assertEquals(1, books.size());
    }
    
    @Test
    public void testBooksSortedByTitle() {
        Library library = new Library();
        library.addBook(new Book("Dune", "Frank Herbert", 1965));
        library.addBook(new Book("1984", "George Orwell", 1949));
        List<Book> sorted = library.getBooksSortedByTitle();
        assertEquals("1984", sorted.get(0).getTitle());
    }
    
    @Test
    public void testSearchBooksByKeyword() {
        Library library = new Library();
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        List<Book> results = library.searchBooksByKeyword("gatsby");
        assertEquals(1, results.size());
    }


}
