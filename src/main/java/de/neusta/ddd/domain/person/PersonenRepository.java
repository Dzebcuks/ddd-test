package de.neusta.ddd.domain.person;

import de.neusta.ddd.domain.person.valueobject.PersonId;
import de.neusta.ddd.domain.raum.Raum;

import java.util.Optional;

public interface PersonenRepository {
    PersonId legePersonAn(Person person);

    boolean benutzernameVergeben(String benutzername);

    Optional<Person> findePerson(PersonId personId);
}
