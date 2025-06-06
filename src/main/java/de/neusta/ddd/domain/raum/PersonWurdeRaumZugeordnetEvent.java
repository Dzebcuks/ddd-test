package de.neusta.ddd.domain.raum;

import de.neusta.ddd.domain.person.Person;

public class PersonWurdeRaumZugeordnetEvent {

    private Person person;
    private Raum raum;

    public PersonWurdeRaumZugeordnetEvent(Person person, Raum raum) {
        this.person = person;
        this.raum = raum;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(final Person person) {
        this.person = person;
    }

    public Raum getRaum() {
        return raum;
    }

    public void setRaum(final Raum raum) {
        this.raum = raum;
    }
}
