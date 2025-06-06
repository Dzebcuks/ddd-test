package de.neusta.ddd.domain;

public interface RaumRepository {

    Raum findeRaumPerID(Raum.RaumID raumID);

    Raum.RaumID legeRaumAn(Raum raum);

    boolean existiertRaumMitNummer(Raum.RaumNummer raumNummer);
}
