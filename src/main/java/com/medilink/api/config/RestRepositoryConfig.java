package com.medilink.api.config;

import com.medilink.api.domain.entity.Especialidad;
import com.medilink.api.domain.entity.Medico;
import com.medilink.api.domain.entity.Paciente;
import com.medilink.api.domain.entity.Usuario;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestRepositoryConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        // Exponer IDs para las entidades usadas por Spring Data REST
        config.exposeIdsFor(Medico.class, Usuario.class, Paciente.class, Especialidad.class);
    }
}
