package pt.bmo.quarkus.gettingstarted.repository;

import jakarta.enterprise.context.ApplicationScoped;
import pt.bmo.quarkus.gettingstarted.model.Book;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {
    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "understanding quarkus", "Antonio", 2020, "IT"),
                new Book(2, "test 2", "Antonio", 2020, "IT"),
                new Book(3, "test3", "Antonio", 2020, "IT"),
                new Book(4, "true at first light", "hemingway", 1999, "novel")
        );
    }

    public Optional<Book> getById(final int id) {
        return getAllBooks()
                .stream()
                .filter(book -> book.id() == id)
                .findFirst();
    }
}
