package de.neusta.ddd.infrastructure.raum;

import de.neusta.ddd.domain.person.valueobject.PersonId;
import de.neusta.ddd.domain.raum.PersonWurdeRaumZugeordnetEvent;
import de.neusta.ddd.domain.raum.Raum;
import de.neusta.ddd.domain.raum.RaumRepository;
import org.springframework.stereotype.Component;

@Component
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

    @Override
    public Raum personZuRaumZuordnen(final PersonId personId, final Raum.RaumID raumId) {
        return null;
    }

    @Override
    public void werfePersonZuRaumHinzugefügtEvent(final PersonWurdeRaumZugeordnetEvent event) {

    }
}
