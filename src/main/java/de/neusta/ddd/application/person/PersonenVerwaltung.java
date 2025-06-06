package de.neusta.ddd.application.person;

import de.neusta.ddd.domain.person.Person;
import de.neusta.ddd.domain.person.PersonenRepository;
import org.springframework.stereotype.Component;

@Component
public class PersonenVerwaltung {
    private final PersonenRepository repository;

    public PersonenVerwaltung(PersonenRepository repository) {
        this.repository = repository;
    }

    public String legePersonAn(Person person) {
        if (repository.benutzernameVergeben(person.getBenutzername().getValue())) {
            throw new IllegalArgumentException("Benutzername bereits vergeben");
        }
        return repository.legePersonAn(person).getValue().toString();
    }
}
