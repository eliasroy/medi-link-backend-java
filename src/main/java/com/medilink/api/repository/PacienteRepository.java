package com.medilink.api.repository;

import com.medilink.api.domain.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "pacientes", collectionResourceRel = "pacientes")
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}