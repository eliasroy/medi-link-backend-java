package com.medilink.api.controller.auth.dto;

public record LoginRequest (
        String email,
        String password
) {
}
