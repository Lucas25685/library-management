package com.example.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        if (!books.contains(book)) {
            books.add(book);
        }
    }

    public boolean removeBook(String title) {
        return books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    public Book findBook(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public void displayBooks() {
        books.forEach(System.out::println);
    }
    
    public List<Book> getBooksSortedByTitle() {
        return books.stream()
                    .sorted(Comparator.comparing(book -> book.getTitle().toLowerCase()))
                    .collect(Collectors.toList());
    }
    
    public List<Book> searchBooksByKeyword(String keyword) {
        return books.stream()
                    .filter(book -> book.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                    .collect(Collectors.toList());
    }
    
    public void exportBooksToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Book book : books) {
                writer.write(book.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de l'export : " + e.getMessage());
        }
    }
}
