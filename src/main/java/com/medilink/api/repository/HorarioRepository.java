package com.medilink.api.repository;

import com.medilink.api.domain.entity.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('MEDICO')")
@RepositoryRestResource(collectionResourceRel = "horarios", path = "horarios")
public interface HorarioRepository extends JpaRepository<Horario, Long> {
}
