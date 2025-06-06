package de.neusta.ddd.infrastructure.raum;

import de.neusta.ddd.application.raum.RaumAbfrage;
import de.neusta.ddd.application.raum.RaumAnlage;
import de.neusta.ddd.application.raum.RaumPersonenDTO;
import de.neusta.ddd.application.raum.RaumPersonenService;
import de.neusta.ddd.domain.person.Person;
import de.neusta.ddd.domain.person.valueobject.PersonId;
import de.neusta.ddd.domain.person.valueobject.RaumId;
import de.neusta.ddd.domain.raum.Raum;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RaumController {

    @Resource
    private RaumAbfrage raumAbfrage;
    @Resource
    private RaumAnlage raumAnlage;
    @Resource
    private RaumPersonenService raumPersonenService;

    @GetMapping("/api/raum/{raumID}")
    public RaumDTO findeRaumPerId(@PathVariable final String raumID) {
        return convert(raumAbfrage.findeRaumPerID(raumID));
    }

    @PostMapping("/api/raum")
    public ResponseEntity<String> legeRaumAn(@RequestBody final RaumDTO raumDTO) {
        try {
            return ResponseEntity.ok(raumAnlage.legeRaumAn(raumDTO.getRaumName(), raumDTO.getRaumNummer()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).build();
        }
    }

    @PutMapping("/room/{raumId}/person/{personId}")
    public void personZuRaumZuordnen(@PathVariable String raumId, @PathVariable String personId) {
        raumPersonenService.fügeHinzu(personId, raumId);
    }

    private RaumDTO convert(final RaumPersonenDTO raum) {
        final RaumDTO raumDTO = new RaumDTO();
        raumDTO.setRaumId(raum.getRaumID().toString());
        raumDTO.setRaumName(raum.getRaumName().getName());
        raumDTO.setRaumNummer(raum.getRaumNummer().getNummer());
        raumDTO.setPersonen(raum.getPersonen().stream()
                .map(Person::getKurzschreibweise)
                .toList());
        return raumDTO;
    }
}
