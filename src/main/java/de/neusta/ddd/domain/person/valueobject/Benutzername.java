package de.neusta.ddd.domain.person.valueobject;

import java.util.Objects;

public class Benutzername {
    private final String value;

    public Benutzername(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Benutzername darf nicht leer sein");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    // ...equals, hashCode, toString...
}
