package com.example.library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Ajouter des livres
        library.addBook(new Book("1984", "George Orwell", 1949));
        library.addBook(new Book("Dune", "Frank Herbert", 1965));
        library.addBook(new Book("Le Petit Prince", "Antoine de Saint-Exupéry", 1943));

        // Exporter les livres dans un fichier texte
        library.exportBooksToFile("livres.txt");

        System.out.println("Les livres ont été exportés dans 'livres.txt'.");
    }
}

