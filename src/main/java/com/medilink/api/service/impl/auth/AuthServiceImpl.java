package com.medilink.api.service.impl.auth;

import com.medilink.api.controller.auth.dto.LoginResponse;
import com.medilink.api.controller.auth.dto.UsuarioDTO;
import com.medilink.api.domain.entity.Medico;
import com.medilink.api.domain.entity.Paciente;
import com.medilink.api.domain.entity.Usuario;
import com.medilink.api.repository.MedicoRepository;
import com.medilink.api.repository.PacienteRepository;
import com.medilink.api.repository.UsuarioRepository;
import com.medilink.api.service.inter.auth.AuthServiceInter;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthServiceInter {
    private final UsuarioRepository usuarioRepository;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Override
    public LoginResponse login(String email, String password) {
        Optional<Usuario> optUsuario = usuarioRepository.findByEmail(email);
        if (optUsuario.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
        }
        Usuario usuario = optUsuario.get();

        if (!passwordEncoder.matches(password, usuario.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Contraseña incorrecta");
        }

        String jwtSecret = System.getenv("JWT_SECRET");
        if (jwtSecret == null || jwtSecret.isBlank()) {
            throw new IllegalStateException("JWT_SECRET no está definido en las variables de entorno");
        }

        // Ajustar los métodos de búsqueda según tus repositorios (findByIdUsuario...).
        Optional<Medico> optMedico = medicoRepository.findByUsuario_IdUsuario(usuario.getIdUsuario());
        Optional<Paciente> optPaciente = pacienteRepository.findByUsuario_IdUsuario(usuario.getIdUsuario());

        Long idUser = null;
        if (optMedico.isPresent()) {
            idUser = optMedico.get().getIdMedico();
        } else if (optPaciente.isPresent()) {
            idUser = optPaciente.get().getIdPaciente();
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El usuario no tiene perfil de MÉDICO o PACIENTE");
        }

        Date expiry = new Date(System.currentTimeMillis() + 11L * 60 * 60 * 1000); // 11 horas
        String token = Jwts.builder()
                .setSubject(String.valueOf(idUser))
                .claim("rol", usuario.getRol())
                .setExpiration(expiry)
                .signWith(SignatureAlgorithm.HS256, jwtSecret.getBytes())
                .compact();

        UsuarioDTO usuarioDto = new UsuarioDTO(usuario.getIdUsuario(), usuario.getEmail(), usuario.getRol());

        return new LoginResponse("Login exitoso", token, idUser, usuarioDto);
    }
}
