package pt.bmo.quarkus.gettingstarted;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;
import pt.bmo.quarkus.gettingstarted.model.Book;
import pt.bmo.quarkus.gettingstarted.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    private BookRepository bookRepository;

    @Inject
    private Logger logger;

    @GET
    public List<Book> getAllBooks() {
        logger.info("Getting all books");
        return bookRepository.getAllBooks();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks() {
        logger.info("Getting count of all books");
        return bookRepository.getAllBooks().size();
    }

    @GET
    @Path("{id}")
    public Optional<Book> getById(@PathParam("id") int id) {
        logger.info("Getting book by id=" + id);
        return bookRepository.getById(id);
    }
}
