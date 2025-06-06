package de.neusta.ddd.domain.person.valueobject;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Zusatz {
    private static final List<String> ALLOWED = Arrays.asList("von", "van", "de");
    private final String value;

    public Zusatz(String value) {
        if (!ALLOWED.contains(value)) {
            throw new IllegalArgumentException("Zusatz muss einer der Werte sein: von, van, de");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    // ...equals, hashCode, toString...
}
