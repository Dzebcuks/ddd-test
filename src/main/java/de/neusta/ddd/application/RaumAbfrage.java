package de.neusta.ddd.application;

import de.neusta.ddd.domain.Raum;
import de.neusta.ddd.domain.RaumRepository;
import jakarta.annotation.Resource;

import java.util.UUID;

public class RaumAbfrage {

    @Resource
    private RaumRepository raumRepository;

    public Raum findeRaumPerID(String raumID) {
        return raumRepository.findeRaumPerID(new Raum.RaumID(UUID.fromString(raumID)));
    }
}
