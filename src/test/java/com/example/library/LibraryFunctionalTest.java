package com.example.library;

import org.junit.jupiter.api.Test;

public class LibraryFunctionalTest {

    @Test
    public void testFullScenario() {
        Library library = new Library();

        // �tape 1 : Ajouter 1984
        library.addBook(new Book("1984", "George Orwell", 1949));

        // �tape 2 : Ajouter Dune
        library.addBook(new Book("Dune", "Frank Herbert", 1965));

        // �tape 3 : Supprimer 1984
        library.removeBook("1984");

        // �tape 4 : Affichage
        System.out.println("Livres restants dans la bibliotheque :");
        library.displayBooks();
    }
}
