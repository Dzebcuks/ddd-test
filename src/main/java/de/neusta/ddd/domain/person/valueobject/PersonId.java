package de.neusta.ddd.domain.person.valueobject;

import java.util.Objects;
import java.util.UUID;

public class PersonId {
    private final UUID value;

    public PersonId(UUID value) {
        this.value = Objects.requireNonNull(value, "PersonId darf nicht null sein");
    }

    public PersonId(String value) {
        this.value = Objects.requireNonNull(UUID.fromString(value), "PersonId darf nicht null sein");
    }

    public static PersonId random() {
        return new PersonId(UUID.randomUUID());
    }

    public UUID getValue() {
        return value;
    }

    // ...equals, hashCode, toString...
}
