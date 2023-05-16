package com.synnigeograafia.backend.domain;

import com.mongodb.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Entity
@Document(collation = "avalikud_tegelased")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {

    @Id
    @Column(name = "_id")
    private ObjectId id;
    @Nullable
    @Column(name = "Perekonnanimi")
    private String perekonnanimi;
    @Nullable
    @Column(name = "Eesnimi")
    private String eesnimi;
    @Nullable
    @Column(name = "Varjunimi")
    private String varjunimi;
    @Nullable
    @Column(name = "Sünniaeg")
    private String synniaeg;
    @Nullable
    @Column(name = "Sünnikoht")
    private String synnikoht;
    @Nullable
    @Column(name = "Surmaaeg")
    private String surmaaeg;
    @Nullable
    @Column(name = "Valdkond")
    private String valdkond;
    @Nullable
    @Column(name = "Tunnus")
    private String tunnus;


}
