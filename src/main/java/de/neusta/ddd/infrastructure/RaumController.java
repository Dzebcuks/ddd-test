package de.neusta.ddd.infrastructure;

import de.neusta.ddd.application.RaumAbfrage;
import de.neusta.ddd.application.RaumAnlage;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RaumController {

    @Resource
    private RaumAbfrage raumAbfrage;
    @Resource
    private RaumAnlage raumAnlage;

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

    private RaumDTO convert(final de.neusta.ddd.domain.Raum raum) {
        final RaumDTO raumDTO = new RaumDTO();
        raumDTO.setRaumId(raum.getRaumID().toString());
        raumDTO.setRaumName(raum.getRaumName().getName());
        raumDTO.setRaumNummer(raum.getRaumNummer().getNummer());
        return raumDTO;
    }
}
