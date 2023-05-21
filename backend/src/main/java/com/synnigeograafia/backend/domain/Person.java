package com.synnigeograafia.backend.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id //Will be changed to uuid
    @Column(name = "id", length = 36, columnDefinition = "varchar", updatable = false)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Nullable
    @Column(name = "eesnimi")
    private String eesnimi;
    @Nullable
    @Column(name = "perekonnanimi")
    private String perekonnanimi;
    @Nullable
    @Column(name = "varjunimi")
    private String varjunimi;
    @Nullable
    @Column(name = "synniaeg")
    private String synniaeg;
    @Nullable
    @Column(name = "kasvukoht")
    private String kasvukoht;
    @Nullable
    @Column(name = "surmaaeg")
    private String surmaaeg;
    @Nullable
    @Column(name = "valdkond")
    private String valdkond;
    @Nullable
    @Column(name = "tunnus")
    private String tunnus;

}
