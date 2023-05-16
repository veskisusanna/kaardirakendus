package com.synnigeograafia.backend.repository;

import com.synnigeograafia.backend.domain.Person;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoPersonRepository extends MongoRepository<Person, ObjectId> {
}
