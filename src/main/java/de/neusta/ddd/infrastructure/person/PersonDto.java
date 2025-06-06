package de.neusta.ddd.infrastructure.person;

import de.neusta.ddd.domain.person.Person;
import de.neusta.ddd.domain.person.valueobject.*;

import java.util.UUID;

public class PersonDto {
    public String id;
    public String vorname;
    public String nachname;
    public String benutzername;
    public String zusatz;

    public Person toPerson() {
        return new Person(
            new PersonId(id != null ? UUID.fromString(id) : UUID.randomUUID()),
            new Vorname(vorname),
            new Nachname(nachname),
            new Benutzername(benutzername),
            zusatz != null ? new Zusatz(zusatz) : null
        );
    }
}
