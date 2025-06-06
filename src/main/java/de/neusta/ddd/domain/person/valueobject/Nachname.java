package de.neusta.ddd.domain.person.valueobject;

import java.util.Objects;

public class Nachname {
    private final String value;

    public Nachname(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    // ...equals, hashCode, toString...
}
