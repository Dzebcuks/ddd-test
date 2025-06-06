package de.neusta.ddd.application.raum;

import de.neusta.ddd.domain.raum.Raum;
import de.neusta.ddd.domain.person.Person;

import java.util.List;

public class RaumPersonenDTO {

    private Raum.RaumID raumID;
    private Raum.RaumName raumName;
    private Raum.RaumNummer raumNummer;
    private List<Person> personen;

    public RaumPersonenDTO(Raum raum, List<Person> personen) {
        this.raumID = raum.getRaumID();
        this.raumName = raum.getRaumName();
        this.raumNummer = raum.getRaumNummer();
        this.personen = personen;
    }

    public Raum.RaumID getRaumID() {
        return raumID;
    }

    public void setRaumID(final Raum.RaumID raumID) {
        this.raumID = raumID;
    }

    public Raum.RaumName getRaumName() {
        return raumName;
    }

    public void setRaumName(final Raum.RaumName raumName) {
        this.raumName = raumName;
    }

    public Raum.RaumNummer getRaumNummer() {
        return raumNummer;
    }

    public void setRaumNummer(final Raum.RaumNummer raumNummer) {
        this.raumNummer = raumNummer;
    }

    public List<Person> getPersonen() {
        return personen;
    }

    public void setPersonen(final List<Person> personen) {
        this.personen = personen;
    }
}
