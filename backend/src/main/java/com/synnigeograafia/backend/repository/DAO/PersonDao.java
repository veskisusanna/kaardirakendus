package com.synnigeograafia.backend.repository.DAO;

import com.synnigeograafia.backend.domain.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface PersonDao {
    Optional<Person> selectPersonById(UUID id);
    List<Person> selectAllPersons();
    List<Person> selectPersonByNameLikeIgnoreCase(String name);
}
