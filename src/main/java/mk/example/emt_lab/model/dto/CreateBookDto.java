package mk.example.emt_lab.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import mk.example.emt_lab.model.domain.Author;
import mk.example.emt_lab.model.domain.Book;
import mk.example.emt_lab.model.enums.Category;
import mk.example.emt_lab.model.enums.State;



public record CreateBookDto(
        @NotBlank(message = "Name must not be empty")
        String name,
        @NotNull(message = "Category must be selected")
        Category category,
        Long authorId,
        State state,
        @Positive
        Integer availableCopies,
        Boolean deleted


) {
    public Book toBook(Author author) {
        return new Book(author,availableCopies,category,name,state,deleted);

    }


}
