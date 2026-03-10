package mk.example.emt_lab.service.domain.impl;


import mk.example.emt_lab.model.domain.Book;
import mk.example.emt_lab.model.enums.Category;
import mk.example.emt_lab.model.enums.State;
import mk.example.emt_lab.model.exception.BookNotFoundException;
import mk.example.emt_lab.model.exception.NoAvailableCopiesException;
import mk.example.emt_lab.repository.BookRepository;
import mk.example.emt_lab.service.domain.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book create(Book book) {
        return bookRepository
                .save(book);
    }


    @Override
    public Optional<Book> deleteById(Long id) {
        Optional<Book> optionalBook = bookRepository.findByIdAndDeletedFalse(id);

        if (optionalBook.isEmpty()) {
            return Optional.empty();
        }

        Book book = optionalBook.get();


        book.setDeleted(true);
        bookRepository.save(book);

        return optionalBook;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAllByDeletedFalse();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findByIdAndDeletedFalse(id);
    }

    @Override
    public Optional<Book> markAsRented(Long id) {
       Book book=bookRepository.findByIdAndDeletedFalse(id)
               .orElseThrow(()->new BookNotFoundException(id));

        if (book.getAvailableCopies() <= 0) {
            throw new NoAvailableCopiesException(id);
        }

        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> update(Long id, Book book) {
     return bookRepository
                .findByIdAndDeletedFalse(id)
                .map((existingBook) -> {
                  existingBook.setName(book.getName());
                  existingBook.setAuthor(book.getAuthor());
                  existingBook.setCategory(book.getCategory());
                  existingBook.setState(book.getState());
                  existingBook.setAvailableCopies(book.getAvailableCopies());

                    return bookRepository.save(existingBook);
                });
    }

    @Override
    public List<Book> findAllByCategory(Category category) {
        return bookRepository
                .findAllByCategoryAndDeletedFalse(category);
    }
}
