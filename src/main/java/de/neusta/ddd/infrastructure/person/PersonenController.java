package de.neusta.ddd.infrastructure.person;

import de.neusta.ddd.application.person.PersonenVerwaltung;
import de.neusta.ddd.domain.person.Person;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonenController {

    @Resource
    private PersonenVerwaltung useCase;

    @PostMapping("/person")
    public String legePersonAn(@RequestBody PersonDto dto) {
        Person person = dto.toPerson();
        return useCase.legePersonAn(person);
    }
}
