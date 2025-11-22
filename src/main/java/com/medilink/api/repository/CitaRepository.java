package com.medilink.api.repository;

import com.medilink.api.domain.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('PACIENTE')")
@RepositoryRestResource(collectionResourceRel = "citas", path = "citas")
public interface CitaRepository extends JpaRepository<Cita, Long> {
}