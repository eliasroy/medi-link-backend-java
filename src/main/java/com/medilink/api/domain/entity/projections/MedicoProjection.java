package com.medilink.api.domain.entity.projections;

import com.medilink.api.domain.entity.Especialidad;
import com.medilink.api.domain.entity.Usuario;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface MedicoProjection {
    Long getIdMedico();
    String getNroColegiatura();
    Integer getAniosExperiencia();
    BigDecimal getCalificacionPromedio();
    LocalDateTime getFechaRegistro();
    LocalDateTime getFechaActualizacion();

    Especialidad getEspecialidad();
    Usuario getUsuario();
}
