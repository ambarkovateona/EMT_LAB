package mk.example.emt_lab.model.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="authors")
public class Author extends BaseAuditableEntity{
    private String name;
    private String surname;
    @ManyToOne
    private Country country;

    public Author(Country country, String name, String surname) {
        this.country = country;
        this.name = name;
        this.surname = surname;
    }

    public Author() {
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
