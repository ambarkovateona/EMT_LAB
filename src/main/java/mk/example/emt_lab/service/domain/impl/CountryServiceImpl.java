package mk.example.emt_lab.service.domain.impl;

import mk.example.emt_lab.model.domain.Country;
import mk.example.emt_lab.repository.CountryRepository;
import mk.example.emt_lab.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country create(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Optional<Country> deleteById(Long id) {
        Optional<Country> country =countryRepository.findById(id);
        countryRepository.delete(country.get());
        return Optional.of(country.get());
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Optional<Country> update(Long id, Country country) {
        return countryRepository.findById(id)
                .map((existingCountry) -> {
                    existingCountry.setName(country.getName());
                    existingCountry.setContinent(country.getContinent());

                    return countryRepository.save(existingCountry);
                });
    }
}
