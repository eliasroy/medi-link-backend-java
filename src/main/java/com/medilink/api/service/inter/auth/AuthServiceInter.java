package com.medilink.api.service.inter.auth;

import com.medilink.api.controller.auth.dto.LoginResponse;

public interface AuthServiceInter {
    LoginResponse login(String email, String password);
}
