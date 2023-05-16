package com.synnigeograafia.backend.service.Impl;

import com.synnigeograafia.backend.domain.Person;
import com.synnigeograafia.backend.repository.MongoPersonRepository;
import com.synnigeograafia.backend.service.PersonService;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private final MongoPersonRepository personRepository;

    public PersonServiceImpl(MongoPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person getPersonById(ObjectId id) {
//        return this.personRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Person with id " + id + " not found"));
        return this.personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person with id " + id + " not found"));
    }
}
