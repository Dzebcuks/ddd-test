package de.neusta.ddd.domain.raum;

import de.neusta.ddd.domain.person.valueobject.PersonId;

public interface RaumRepository {

    Raum findeRaumPerID(Raum.RaumID raumID);

    Raum.RaumID legeRaumAn(Raum raum);

    boolean existiertRaumMitNummer(Raum.RaumNummer raumNummer);

    Raum personZuRaumZuordnen(PersonId personId, Raum.RaumID raumId);

    void werfePersonZuRaumHinzugefügtEvent(PersonWurdeRaumZugeordnetEvent event);
}
