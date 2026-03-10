package mk.example.emt_lab.model.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id) {
        super("A book with id %d does not exist.".formatted(id));
    }
}
