package com.medilink.api.repository;


import com.medilink.api.domain.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "medicos", collectionResourceRel = "medicos")
public interface MedicoRepository extends JpaRepository<Medico, Long> {
}