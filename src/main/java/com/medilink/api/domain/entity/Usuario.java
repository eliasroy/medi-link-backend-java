package com.medilink.api.domain.entity;


import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuario", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "paterno", nullable = false)
    private String paterno;

    @Column(name = "materno", nullable = false)
    private String materno;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "telefono")
    private Integer telefono;

    @Column(name = "password", nullable = false, columnDefinition = "text")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol", nullable = false)
    private Rol rol = Rol.PACIENTE;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "fecha_actualizacion", nullable = false)
    private LocalDateTime fechaActualizacion;

    public enum Rol {
        MEDICO, PACIENTE
    }
}