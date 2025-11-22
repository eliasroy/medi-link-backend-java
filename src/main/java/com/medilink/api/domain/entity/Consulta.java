package com.medilink.api.domain.entity;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.medilink.api.domain.dto.EstadoConsulta;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "consultas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta")
    private Long idConsulta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cita", nullable = false)
    private Cita cita;

    @Column(name = "motivo", columnDefinition = "text")
    private String motivo;

    @Column(name = "diagnostico", columnDefinition = "text")
    private String diagnostico;

    @Column(name = "pathArchivo", columnDefinition = "text")
    private String pathArchivo;

    @Column(name = "tratamiento", columnDefinition = "text")
    private String tratamiento;

    @Column(name = "observaciones", columnDefinition = "text")
    private String observaciones;

    @Column(name = "calificacion")
    private Integer calificacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 30)
    private EstadoConsulta estado = EstadoConsulta.INICIADO;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "fecha_actualizacion", nullable = false)
    private LocalDateTime fechaActualizacion;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.fechaRegistro = now;
        this.fechaActualizacion = now;
    }

    @PreUpdate
    protected void onUpdate() {
        this.fechaActualizacion = LocalDateTime.now();
    }
}