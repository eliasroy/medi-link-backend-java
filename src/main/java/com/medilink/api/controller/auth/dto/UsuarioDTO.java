package com.medilink.api.controller.auth.dto;

import com.medilink.api.domain.entity.Usuario;

public record UsuarioDTO(Long id, String email, Usuario.Rol rol) {
}
