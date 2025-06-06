package de.neusta.ddd.infrastructure.raum;

import java.util.List;

public class RaumDTO {

    private String raumNummer;
    private String raumName;
    private String raumId;
    private List<String> personen;

    public String getRaumNummer() {
        return raumNummer;
    }

    public void setRaumNummer(final String raumNummer) {
        this.raumNummer = raumNummer;
    }

    public String getRaumName() {
        return raumName;
    }

    public void setRaumName(final String raumName) {
        this.raumName = raumName;
    }

    public String getRaumId() {
        return raumId;
    }

    public void setRaumId(final String raumId) {
        this.raumId = raumId;
    }

    public List<String> getPersonen() {
        return personen;
    }

    public void setPersonen(final List<String> personen) {
        this.personen = personen;
    }
}
