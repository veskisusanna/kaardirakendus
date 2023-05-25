package com.synnigeograafia.backend.mapper;

import com.synnigeograafia.backend.domain.Person;
import com.synnigeograafia.backend.model.PersonDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PersonMapper {

    Person personDtoToPerson(PersonDTO dto);
    PersonDTO personToPersonDto(Person person);
}
