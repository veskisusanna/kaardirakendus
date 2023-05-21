package com.synnigeograafia.backend.service.Impl;

import com.synnigeograafia.backend.domain.Person;
import com.synnigeograafia.backend.exception.PersonNotFoundException;
import com.synnigeograafia.backend.repository.PersonJDBCDataAccessService;
import com.synnigeograafia.backend.service.PersonDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PersonJDBCDataAccessServiceImpl implements PersonDao {

    private final PersonJDBCDataAccessService personJDBCDataAccessService;

    public PersonJDBCDataAccessServiceImpl(PersonJDBCDataAccessService personJDBCDataAccessService) {
        this.personJDBCDataAccessService = personJDBCDataAccessService;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        // Use orElseThrow when mapping this to DTO
         return this.personJDBCDataAccessService.selectPersonById(id);
    }

    @Override
    public List<Person> selectAllPersons() {
        return this.personJDBCDataAccessService.selectAllPersons();
    }

    @Override
    public List<Person> selectPersonByNameLikeIgnoreCase(String name) {
        return new ArrayList<>(this.personJDBCDataAccessService.selectPersonByNameLikeIgnoreCase(name));
    }

    @Override
    public List<String> selectOnlyPersonNameLikeIgnoreCase(String name) {
        return new ArrayList<>(this.personJDBCDataAccessService.selectOnlyPersonNameLikeIgnoreCase(name));
    }
}
