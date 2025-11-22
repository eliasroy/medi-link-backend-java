package com.medilink.api.repository;


import com.medilink.api.domain.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasRole('MEDICO') or hasRole('PACIENTE')")
@RepositoryRestResource(collectionResourceRel = "consultas", path = "consultas")
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}