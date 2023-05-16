package com.synnigeograafia.backend.service;

import com.synnigeograafia.backend.domain.Person;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public interface PersonService {

    public Person getPersonById(ObjectId id);
}
