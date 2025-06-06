package de.neusta.ddd.domain;

import org.springframework.util.StringUtils;

import java.util.UUID;

public class Raum {

    private RaumID raumID;
    private RaumName raumName;
    private RaumNummer raumNummer;

    public Raum(RaumName raumName, RaumNummer raumNummer) {
        this.raumID = new RaumID(UUID.randomUUID());
        this.raumName = raumName;
        this.raumNummer = raumNummer;
    }

    public RaumID getRaumID() {
        return raumID;
    }

    public void setRaumID(final RaumID raumID) {
        this.raumID = raumID;
    }

    public RaumName getRaumName() {
        return raumName;
    }

    public void setRaumName(final RaumName raumName) {
        this.raumName = raumName;
    }

    public RaumNummer getRaumNummer() {
        return raumNummer;
    }

    public void setRaumNummer(final RaumNummer raumNummer) {
        this.raumNummer = raumNummer;
    }

    public static class RaumID {
        private final UUID id;

        public RaumID(UUID id) {
            this.id = id;
        }

        public UUID getId() {
            return id;
        }
    }

    public static class RaumName {
        private final String name;

        public RaumName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class RaumNummer {
        private final String nummer;

        public RaumNummer(String nummer) {
            if (!istRaumNummerGültig(nummer)) {
                throw new IllegalArgumentException("Raumnummer muss genau 4 Ziffern enthalten.");
            }
            this.nummer = nummer;
        }

        public String getNummer() {
            return nummer;
        }

        private boolean istRaumNummerGültig(String nummer) {
            return nummer.matches("\\d{4}");
        }
    }
}
