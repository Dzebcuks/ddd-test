package de.neusta.ddd.application.raum;

import de.neusta.ddd.domain.person.Person;
import de.neusta.ddd.domain.person.PersonenRepository;
import de.neusta.ddd.domain.person.valueobject.PersonId;
import de.neusta.ddd.domain.raum.PersonWurdeRaumZugeordnetEvent;
import de.neusta.ddd.domain.raum.Raum;
import de.neusta.ddd.domain.raum.RaumRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RaumPersonenService {

    @Resource
    private PersonenRepository personenRepository;
    @Resource
    private RaumRepository raumRepository;

    public void fügeHinzu(String personIdValue, String raumIdValue) {
        final PersonId personId = new PersonId(personIdValue);
        final Raum.RaumID raumID = new Raum.RaumID(raumIdValue);

        final Optional<Person> person = personenRepository.findePerson(personId);

        if (person.isEmpty()) {
            throw new IllegalArgumentException("Person mit ID " + personIdValue + " existiert nicht.");
        }

        final Raum raum = raumRepository.findeRaumPerID(raumID);
        if (raum == null) {
            throw new IllegalArgumentException("Raum mit ID " + raumIdValue + " existiert nicht.");
        }

        raumRepository.personZuRaumZuordnen(personId, raumID);
        raumRepository.werfePersonZuRaumHinzugefügtEvent(new PersonWurdeRaumZugeordnetEvent(person.get(), raum));

    }
}
