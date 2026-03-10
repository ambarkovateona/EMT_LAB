package mk.example.emt_lab.model.exception;

public class NoAvailableCopiesException extends RuntimeException {
    public NoAvailableCopiesException(Long id) {
        super("No available copies for book with id " + id);
    }
}
