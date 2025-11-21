package com.medilink.api.controller.auth.dto;

import com.medilink.api.domain.entity.Usuario;

public record LoginResponse(String message, String token, Long userId, UsuarioDTO usuario) {
}
