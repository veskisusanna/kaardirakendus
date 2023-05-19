package com.synnigeograafia.backend.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {


    @Nullable
    @Column(name = "perekonnanimi")
    private String perekonnanimi;
    @Nullable
    @Column(name = "eesnimi")
    private String eesnimi;
    @Nullable
    @Column(name = "surmaaeg")
    private String surmaaeg;
    @Nullable
    @Column(name = "synniaeg")
    private String synniaeg;
    @Nullable
    @Column(name = "kasvukoht")
    private String kasvukoht;
    @Nullable
    @Column(name = "tunnus")
    private String tunnus;
    @Nullable
    @Column(name = "valdkond")
    private String valdkond;
    @Nullable
    @Column(name = "varjunimi")
    private String varjunimi;
    @Id //Will be changed to uuid
    @Column(name = "id")
//    @Type("uuid-char")
    private UUID id;

}
