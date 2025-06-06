package de.neusta.ddd.infrastructure.person;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RaumJpaRepository extends JpaRepository<RaumEntity, String> {
    Optional<RaumEntity> findByPersonenIdsContains(String personId);
}
