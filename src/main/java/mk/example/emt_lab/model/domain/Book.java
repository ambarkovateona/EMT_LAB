package mk.example.emt_lab.model.domain;


import jakarta.persistence.*;
import mk.example.emt_lab.model.enums.Category;
import mk.example.emt_lab.model.enums.State;

@Entity
@Table(name="books")
public class Book extends BaseAuditableEntity {
    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;


    @ManyToOne
    private Author author;

    @Enumerated(EnumType.STRING)
    private State state;

    private Integer availableCopies;

    public Book(Author author, Integer availableCopies, Category category, String name, State state) {
        this.author = author;
        this.availableCopies = availableCopies;
        this.category = category;
        this.name = name;
        this.state = state;
    }

    public Book() {
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
