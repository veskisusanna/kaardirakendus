package com.synnigeograafia.backend.service;

import com.synnigeograafia.backend.domain.Person;
import com.synnigeograafia.backend.mapper.PersonMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface PersonService {

    public Person getPersonById(UUID id);

    public List<Person> getAllPersons();
}
