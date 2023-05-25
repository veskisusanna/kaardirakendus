package com.synnigeograafia.backend.service;

import com.synnigeograafia.backend.repository.DAO.PersonDao;
import com.synnigeograafia.backend.exception.PersonNotFoundException;
import com.synnigeograafia.backend.mapper.PersonMapper;
import com.synnigeograafia.backend.model.PersonDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonDao personDao;
    private final PersonMapper personMapper;

    public PersonService(@Qualifier("jdbc") PersonDao personDao, PersonMapper personMapper) {
        this.personDao = personDao;
        this.personMapper = personMapper;
    }

    public List<PersonDTO> getAllPersons(){
        return this.personDao.selectAllPersons()
                .stream()
                .map(personMapper::personToPersonDto)
                .collect(Collectors.toList());
    }

    public PersonDTO getPersonById(UUID personId) {
        return this.personDao.selectPersonById(personId)
                .map(personMapper::personToPersonDto)
                .orElseThrow(() -> new PersonNotFoundException("Person with id: '" + personId + "' not found!"));
    }

    public List<PersonDTO> getPersonByFirstNameIgnoreCaseLike(String name){
        return this.personDao.selectPersonByNameLikeIgnoreCase(name)
                .stream()
                .map(personMapper::personToPersonDto)
                .collect(Collectors.toList());
    }
}
