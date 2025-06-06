package de.neusta.ddd.infrastructure;

import de.neusta.ddd.domain.Raum;
import de.neusta.ddd.domain.RaumRepository;

public class RaumRepositoryImpl implements RaumRepository {
    @Override
    public Raum findeRaumPerID(final Raum.RaumID raumID) {
        return null;
    }

    @Override
    public Raum.RaumID legeRaumAn(final Raum raum) {
        return null;
    }

    @Override
    public boolean existiertRaumMitNummer(final Raum.RaumNummer raumNummer) {
        return false;
    }
}
