package com.medilink.api.repository;


import com.medilink.api.domain.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Optional;

@PreAuthorize("hasRole('MEDICO')")
@RepositoryRestResource(path = "medicos", collectionResourceRel = "medicos")
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Optional<Medico> findByUsuario_IdUsuario(Long usuarioId);
}