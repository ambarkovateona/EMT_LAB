package mk.example.emt_lab.repository;


import mk.example.emt_lab.model.domain.Book;
import mk.example.emt_lab.model.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findAllByDeletedFalse();

    Optional<Book> findByIdAndDeletedFalse(Long id);

    List<Book> findAllByCategoryAndDeletedFalse(Category category);
}
