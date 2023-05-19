package com.synnigeograafia.backend.service;

import com.synnigeograafia.backend.domain.Person;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface PersonService {

    public Person getPersonById(UUID id);
}
