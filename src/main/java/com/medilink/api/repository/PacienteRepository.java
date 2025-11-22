package com.medilink.api.repository;

import com.medilink.api.domain.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Optional;
@PreAuthorize("hasRole('PACIENTE')")
@RepositoryRestResource(path = "pacientes", collectionResourceRel = "pacientes")
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Optional<Paciente> findByUsuario_IdUsuario(Long usuarioId);
}