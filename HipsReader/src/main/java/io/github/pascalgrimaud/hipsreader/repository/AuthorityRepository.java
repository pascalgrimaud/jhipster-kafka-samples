package io.github.pascalgrimaud.hipsreader.repository;

import io.github.pascalgrimaud.hipsreader.domain.Authority;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
