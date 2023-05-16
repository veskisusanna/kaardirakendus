package com.synnigeograafia.backend.controller;

import com.synnigeograafia.backend.domain.Person;
import com.synnigeograafia.backend.service.PersonService;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person")
    public Person getPersonById(@RequestParam ObjectId id){
        return this.personService.getPersonById(id);
    }
}
