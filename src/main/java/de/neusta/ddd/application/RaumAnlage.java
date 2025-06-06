package de.neusta.ddd.application;

import de.neusta.ddd.domain.Raum;
import de.neusta.ddd.domain.RaumRepository;
import jakarta.annotation.Resource;

public class RaumAnlage {

    @Resource
    private RaumRepository raumRepository;

    public String legeRaumAn(String raumName, String raumNummer) {
        if (raumRepository.existiertRaumMitNummer(new Raum.RaumNummer(raumNummer))) {
            throw new IllegalArgumentException("Raum mit dieser Nummer existiert bereits.");
        }
        return raumRepository.legeRaumAn(new Raum(new Raum.RaumName(raumName), new Raum.RaumNummer(raumNummer))).getId().toString();
    }
}
