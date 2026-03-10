package mk.example.emt_lab.service.domain;

import mk.example.emt_lab.model.domain.Author;
import mk.example.emt_lab.model.domain.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    Optional<Country> findById(Long id);

    List<Country> findAll();

    Country create(Country country);

    Optional<Country> update(Long id, Country country);

    Optional<Country> deleteById(Long id);
}
