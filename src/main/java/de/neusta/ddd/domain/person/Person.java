package de.neusta.ddd.domain.person;


import de.neusta.ddd.domain.person.valueobject.Benutzername;
import de.neusta.ddd.domain.person.valueobject.Nachname;
import de.neusta.ddd.domain.person.valueobject.PersonId;
import de.neusta.ddd.domain.person.valueobject.Vorname;
import de.neusta.ddd.domain.person.valueobject.Zusatz;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Person {
    private final PersonId id;
    private final Vorname vorname;
    private final Nachname nachname;
    private final Benutzername benutzername;
    private final Zusatz zusatz;

    public Person(PersonId id, Vorname vorname, Nachname nachname, Benutzername benutzername, Zusatz zusatz) {
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.benutzername = benutzername;
        this.zusatz = zusatz;
    }

    public PersonId getId() {
        return id;
    }

    public Vorname getVorname() {
        return vorname;
    }

    public Nachname getNachname() {
        return nachname;
    }

    public Benutzername getBenutzername() {
        return benutzername;
    }

    public Zusatz getZusatz() {
        return zusatz;
    }

    public String getKurzschreibweise(){
        final String zusatz = Optional.ofNullable(this.zusatz)
                .map(Zusatz::getValue)
                .orElse("");
        return Stream.of(vorname.getValue(), zusatz,nachname.getValue(), "(" + benutzername.getValue() + ")")
                .filter(e -> e != null && !e.isBlank())
                .collect(Collectors.joining(" "));
    }
}
