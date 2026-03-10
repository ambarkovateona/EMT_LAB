package mk.example.emt_lab.service.domain.impl;

import mk.example.emt_lab.model.domain.Author;
import mk.example.emt_lab.model.exception.AuthorNotFoundException;
import mk.example.emt_lab.repository.AuthorRepository;
import mk.example.emt_lab.service.domain.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author create(Author author) {

        return authorRepository.save(author);
    }

    @Override
    public Optional<Author> deleteById(Long id) {
        Author author=authorRepository
                .findById(id)
                .orElseThrow(()->new AuthorNotFoundException(id));
        return Optional.of(author);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Author> update(Long id, Author author) {
        return authorRepository.findById(id)
                .map((existingAuthor) -> {
                    existingAuthor.setName(author.getName());
                    existingAuthor.setSurname(author.getSurname());
                    existingAuthor.setCountry(author.getCountry());

                    return authorRepository.save(existingAuthor);
                });
    }
}
