package mk.example.emt_lab.service.application.impl;
import mk.example.emt_lab.model.domain.Author;
import mk.example.emt_lab.model.domain.Book;
import mk.example.emt_lab.model.dto.CreateBookDto;
import mk.example.emt_lab.model.dto.DisplayBookDto;
import mk.example.emt_lab.model.exception.AuthorNotFoundException;
import mk.example.emt_lab.repository.AuthorRepository;
import mk.example.emt_lab.service.application.BookApplicationService;
import mk.example.emt_lab.service.domain.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookApplicationServiceImpl implements BookApplicationService {

    private final BookService bookService;
    private final AuthorRepository authorRepository;

    public BookApplicationServiceImpl(BookService bookService, AuthorRepository authorRepository) {
        this.bookService = bookService;
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<DisplayBookDto> findById(Long id) {
        return bookService.findById(id)
                .map(DisplayBookDto::from);
    }

    @Override
    public List<DisplayBookDto> findAll() {
        return DisplayBookDto.from(bookService.findAll());
    }

    @Override
    public Optional<DisplayBookDto> create(CreateBookDto createBookDto) {
        Author author = authorRepository.findById(createBookDto.authorId())
                .orElseThrow(() -> new AuthorNotFoundException(createBookDto.authorId()));

        Book book = createBookDto.toBook(author);

        return Optional.of(DisplayBookDto.from(bookService.create(book)));
    }

    @Override
    public Optional<DisplayBookDto> update(Long id, CreateBookDto createBookDto) {
        Author author = authorRepository.findById(createBookDto.authorId())
                .orElseThrow(() -> new AuthorNotFoundException(createBookDto.authorId()));

        Book book = createBookDto.toBook(author);

        return bookService.update(id, book)
                .map(DisplayBookDto::from);
    }

    @Override
    public Optional<DisplayBookDto> deleteById(Long id) {
        return bookService.deleteById(id)
                .map(DisplayBookDto::from);
    }

    @Override
    public Optional<DisplayBookDto> markAsRented(Long id) {
        return bookService.markAsRented(id)
                .map(DisplayBookDto::from);
    }
}