package org.portfolio.ia_programacion_web.config;

import org.portfolio.ia_programacion_web.model.Article;
import org.portfolio.ia_programacion_web.repository.ArticleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initData(ArticleRepository repo) {
        return args -> {
            repo.save(new Article(
                    "Introducción a la Inteligencia Artificial",
                    "La IA permite a las máquinas aprender y tomar decisiones."
            ));

            repo.save(new Article(
                    "Spring Boot para principiantes",
                    "Spring Boot simplifica el desarrollo de aplicaciones Java."
            ));

            repo.save(new Article(
                    "Arquitectura MVC",
                    "Separación de responsabilidades en aplicaciones web."
            ));
        };
    }
}
