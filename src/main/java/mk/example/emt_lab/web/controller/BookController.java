package mk.example.emt_lab.web.controller;

import mk.example.emt_lab.model.enums.Category;
import org.springframework.stereotype.Controller;



import jakarta.validation.Valid;
import mk.example.emt_lab.model.dto.CreateBookDto;
import mk.example.emt_lab.model.dto.DisplayBookDto;
import mk.example.emt_lab.service.application.BookApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookApplicationService bookApplicationService;

    public BookController(BookApplicationService bookApplicationService) {
        this.bookApplicationService = bookApplicationService;
    }

    @GetMapping
    ResponseEntity<List<DisplayBookDto>> findAll(@RequestParam(required = false) Category category) {
        if (category != null) {
            return ResponseEntity.ok(bookApplicationService.findAllByCategory(category));
        }
        return ResponseEntity.ok(bookApplicationService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<DisplayBookDto> findById(@PathVariable Long id) {
        return bookApplicationService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    ResponseEntity<DisplayBookDto> create(@RequestBody @Valid CreateBookDto createBookDto) {
        return bookApplicationService
                .create(createBookDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}/edit")
    ResponseEntity<DisplayBookDto> update(
            @RequestBody @Valid CreateBookDto createBookDto,
            @PathVariable Long id) {
        return bookApplicationService
                .update(id, createBookDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}/delete")
    ResponseEntity<DisplayBookDto> delete(@PathVariable Long id) {
        return bookApplicationService
                .deleteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/rent")
    ResponseEntity<DisplayBookDto> markAsRented(@PathVariable Long id) {
        return bookApplicationService
                .markAsRented(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }
}