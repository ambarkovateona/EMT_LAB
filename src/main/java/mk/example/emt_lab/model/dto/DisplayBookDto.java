package mk.example.emt_lab.model.dto;

import mk.example.emt_lab.model.domain.Book;
import mk.example.emt_lab.model.enums.Category;
import mk.example.emt_lab.model.enums.State;

import java.util.List;

public record DisplayBookDto(
        Long id,
        String name,
        Category category,
        Long authorId,
        State state,
        Integer availableCopies
) {

    public static DisplayBookDto from(Book book) {
        return new DisplayBookDto(
                book.getId(),
                book.getName(),
                book.getCategory(),
                book.getAuthor().getId(),
                book.getState(),
                book.getAvailableCopies()
        );
    }

    public static List<DisplayBookDto> from(List<Book> books) {
        return books
                .stream()
                .map(DisplayBookDto::from)
                .toList();
    }
}