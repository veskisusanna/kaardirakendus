package com.synnigeograafia.backend.repository;

import com.synnigeograafia.backend.domain.Person;
import com.synnigeograafia.backend.service.PersonDao;
import com.synnigeograafia.backend.mapper.PersonRowMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PersonJDBCDataAccessServiceTest {

    @Mock
    private JdbcTemplate jdbcTemplate;
    @Mock
    private PersonRowMapper personRowMapper;
    private PersonDao personDao;
    private Person person1;
    private Person person2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        personDao = new PersonJDBCDataAccessService(jdbcTemplate, personRowMapper);
        person1 = new Person(UUID.randomUUID(), "Teet", "Paat", "teedikas", "19.09.1998", "Tabivere", null, "IT-boss", "IT-imees");
        person2 = new Person(UUID.randomUUID(), "Teet", "Paat", "teedikas", "19.09.1998", "Tabivere", null, "IT-boss", "IT-imees");
    }

    @Test
    void selectPersonById_ReturnOptionalPerson() {
        // Given
        UUID randomId = UUID.randomUUID();
        Person expectedPerson = new Person(randomId, "Teet", "Paat", "teedikas", "19.09.1998", "Tabivere", null, "IT-boss", "IT-imees");
        // When
        when(jdbcTemplate.query(any(String.class), any(PersonRowMapper.class), any(UUID.class)))
                .thenReturn(Collections.singletonList(expectedPerson));
        // Then
        Optional<Person> result = personDao.selectPersonById(randomId);
        assertThat(Optional.of(expectedPerson)).isEqualTo(result);
    }

    @Test
    @Disabled("The first test needs fixing")
    void selectPersonByNonExistingId_ReturnNull(){
        when(jdbcTemplate.query(any(String.class), any(PersonRowMapper.class), any(UUID.class)))
                .thenReturn(Collections.singletonList(person1));

    }

    @Test
    void selectAllPersons_ReturnListOfPeople() {
        // Given
        List<Person> expectedPersons = Collections.singletonList(person1);
        // When
        when(jdbcTemplate.query(any(String.class), any(PersonRowMapper.class)))
                .thenReturn(expectedPersons);
        // Then
        List<Person> result = personDao.selectAllPersons();
        assertThat(expectedPersons).isEqualTo(result);
        assertThat(expectedPersons.size()).isEqualTo(1);
        assertThat(expectedPersons.get(0).getEesnimi()).isEqualTo(person1.getEesnimi());
    }

    @Test
    @Disabled("lamp")
    void selectAllPersons_ReturnListSizeMustBe1824(){
        // Given
        List<Person> allPersons = personDao.selectAllPersons();
//        Person firstPerson = allPersons.get(0);
        // When
        when(jdbcTemplate.query(any(String.class), any(PersonRowMapper.class)))
                .thenReturn(allPersons);
        // Then
        assertThat(allPersons.size()).isEqualTo(1824);
//        assertThat(allPersons.get(0)).isEqualTo(firstPerson);
    }

    @Test
    void selectPersonByNameLikeIgnoreCase() {
        // Given
        // When
        // Then
    }

    @Test
    void selectOnlyPersonNameLikeIgnoreCase() {
        // Given
        // When
        // Then
    }
}