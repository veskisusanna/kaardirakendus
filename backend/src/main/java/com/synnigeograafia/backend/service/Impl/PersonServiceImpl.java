package com.synnigeograafia.backend.service.Impl;

import com.synnigeograafia.backend.domain.Person;
import com.synnigeograafia.backend.exception.PersonNotFoundException;
import com.synnigeograafia.backend.repository.PersonRepository;
import com.synnigeograafia.backend.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person getPersonById(UUID id) {
        return this.personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("Person with id '" + id + "' not found"));
    }

    @Override
    public List<Person> getAllPersons() {
        return this.personRepository.findAll();
    }

}
