package mk.example.emt_lab.service.application;

import mk.example.emt_lab.model.dto.CreateBookDto;
import mk.example.emt_lab.model.dto.DisplayBookDto;
import mk.example.emt_lab.model.enums.Category;

import java.util.List;
import java.util.Optional;

public interface BookApplicationService {
    Optional<DisplayBookDto> findById(Long id);

    List<DisplayBookDto> findAll();

    Optional<DisplayBookDto> create(CreateBookDto createBookDto);

    Optional<DisplayBookDto> update(Long id, CreateBookDto createBookDto);

    Optional<DisplayBookDto> deleteById(Long id);

    Optional<DisplayBookDto> markAsRented(Long id);

    List<DisplayBookDto> findAllByCategory(Category category);
}
