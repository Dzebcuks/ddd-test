package de.neusta.ddd.infrastructure.person;

import de.neusta.ddd.domain.person.Person;
import de.neusta.ddd.domain.person.valueobject.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public class PersonEntity {
    @Id
    private String id;
    private String vorname;
    private String nachname;
    private String benutzername;
    private String zusatz;

    public PersonEntity() {}

    public PersonEntity(String id, String vorname, String nachname, String benutzername, String zusatz) {
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.benutzername = benutzername;
        this.zusatz = zusatz;
    }

    public static PersonEntity fromDomain(Person p) {
        return new PersonEntity(
                p.getId().getValue().toString(),
                p.getVorname().getValue(),
                p.getNachname().getValue(),
                p.getBenutzername().getValue(),
                p.getZusatz() != null ? p.getZusatz().getValue() : null
        );
    }

    public Person toDomain() {
        return new Person(
                new PersonId(java.util.UUID.fromString(id)),
                new Vorname(vorname),
                new Nachname(nachname),
                new Benutzername(benutzername),
                zusatz != null ? new Zusatz(zusatz) : null
        );
    }

    // ...Getter/Setter...
}