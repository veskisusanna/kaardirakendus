package com.synnigeograafia.backend.JDBCTest;

import com.synnigeograafia.backend.repository.PersonJDBCDataAccessService;
import com.synnigeograafia.backend.mapper.PersonRowMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

class PersonJDBCDataAccessServiceTestProov {

    private PersonJDBCDataAccessService underTest;
    private final PersonRowMapper personRowMapper = new PersonRowMapper();

    @BeforeEach
    void setUp() {
        underTest = new PersonJDBCDataAccessService(
                new JdbcTemplate(),
                personRowMapper
        );
    }

    @Test
    void selectPersonById_ReturnOptionalPerson() {
        // Given
        // When
        // Then
    }

    @Test
    void selectAllPersons() {
        // Given
        // When
        // Then
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