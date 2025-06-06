package de.neusta.ddd.domain.person.valueobject;

import java.util.Objects;
import java.util.UUID;

public class RaumId {
    private final UUID value;

    public RaumId(UUID value) {
        this.value = Objects.requireNonNull(value, "RaumId darf nicht null sein");
    }

    public static RaumId random() {
        return new RaumId(UUID.randomUUID());
    }

    public UUID getValue() {
        return value;
    }

    // ...equals, hashCode, toString...
}
