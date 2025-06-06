package de.neusta.ddd.domain.person.valueobject;

import java.util.Objects;

public class Vorname {
    private final String value;

    public Vorname(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    // ...equals, hashCode, toString...
}
