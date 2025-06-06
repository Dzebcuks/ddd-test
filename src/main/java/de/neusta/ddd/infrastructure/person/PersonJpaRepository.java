package de.neusta.ddd.infrastructure.person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonJpaRepository extends JpaRepository<PersonEntity, String> {
    boolean existsByBenutzername(String benutzername);
}
