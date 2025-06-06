package de.neusta.ddd.application.raum;

import de.neusta.ddd.domain.raum.Raum;
import de.neusta.ddd.domain.raum.RaumRepository;
import de.neusta.ddd.domain.person.Person;
import de.neusta.ddd.domain.person.PersonenRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class RaumAbfrage {

    @Resource
    private RaumRepository raumRepository;
    @Resource
    private PersonenRepository personenRepository;

    public RaumPersonenDTO findeRaumPerID(String raumID) {
        final Raum raum = raumRepository.findeRaumPerID(new Raum.RaumID(UUID.fromString(raumID)));
        final List<Person> personen = raum.getPersonen().stream()
                .map(e -> personenRepository.findePerson(e))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
        return new RaumPersonenDTO(raum, personen);
    }
}
