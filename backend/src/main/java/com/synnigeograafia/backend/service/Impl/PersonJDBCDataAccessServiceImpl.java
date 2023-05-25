package com.synnigeograafia.backend.service.Impl;

import com.synnigeograafia.backend.domain.Person;
import com.synnigeograafia.backend.mapper.PersonMapper;
import com.synnigeograafia.backend.model.PersonDTO;
import com.synnigeograafia.backend.repository.PersonJDBCDataAccessService;
import com.synnigeograafia.backend.service.PersonDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonJDBCDataAccessServiceImpl implements PersonDao {

    private final PersonJDBCDataAccessService personJDBCDataAccessService;
    private final PersonMapper personMapper;

    public PersonJDBCDataAccessServiceImpl(PersonJDBCDataAccessService personJDBCDataAccessService, PersonMapper personMapper) {
        this.personJDBCDataAccessService = personJDBCDataAccessService;
        this.personMapper = personMapper;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        // Use orElseThrow when mapping this to DTO
         return this.personJDBCDataAccessService.selectPersonById(id);
//                 .map(personMapper::personToPersonDto);
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
