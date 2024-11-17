package com.devsuperior.dslist.config;
// Classe de configuração de CORS quando a variável estiver configurada no railway app

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
// Anotação que indica que esta classe declara um ou mais métodos @Bean e pode ser processada pelo contêiner
// Spring para gerar definições de bean e solicitações de serviço em tempo de execução.
    public class WebConfig {

        @Value("${cors.origins}")
     // Anotação que injeta o valor da propriedade 'cors.origins' definida em um arquivo de configuração
     // (por exemplo, application.properties) na variável 'corsOrigins'.
        private String corsOrigins;

        @Bean
        public WebMvcConfigurer corsConfigurer() {
      //Anotação que indica que o método 'corsConfigurer' produz um bean que deve ser gerenciado pelo contêiner Spring.
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
               // Método que configura mapeamentos de CORS (Cross-Origin Resource Sharing).
               // Define as permissões de origens, métodos HTTP permitidos e caminhos permitidos para solicitações CORS.
               registry.addMapping("/**").allowedMethods("*").allowedOrigins(corsOrigins);
               // Adiciona um mapeamento para todas as rotas (/**), permitindo todos os métodos HTTP (*),
               // e restringindo as origens conforme definido na variável 'corsOrigins'.
            }
        };
    }

    }

