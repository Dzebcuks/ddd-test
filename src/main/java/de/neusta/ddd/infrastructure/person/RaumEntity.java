package de.neusta.ddd.infrastructure.person;

// Import für JPA-Annotationen
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "raum")
public class RaumEntity {
    @Id
    private String id;

    @ElementCollection
    private List<String> personenIds = new ArrayList<>();

    public RaumEntity() {}

    public RaumEntity(String id, List<String> personenIds) {
        this.id = id;
        this.personenIds = personenIds;
    }

    public String getId() {
        return id;
    }

    public List<String> getPersonenIds() {
        return personenIds;
    }

    // ...Setter...
}