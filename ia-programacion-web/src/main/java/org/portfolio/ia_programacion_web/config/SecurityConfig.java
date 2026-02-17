package org.portfolio.ia_programacion_web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests(auth -> auth
                
                // 4️⃣ Acciones protegidas
                // Por esto (más robusto):
                .requestMatchers("/blog/new/**").hasRole("ADMIN")
               
                // 1️⃣ Recursos estáticos
                .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()

                // 2️⃣ Páginas públicas
                .requestMatchers("/", "/cursos", "/sobre", "/contacto").permitAll()

                // 3️⃣ Blog público
                .requestMatchers("/blog", "/blog/{id}").permitAll()

                // 4️⃣ Acciones protegidas
                // Por esto (más robusto):
                .requestMatchers("/blog/edit/**").hasRole("ADMIN")
                .requestMatchers("/blog/delete/**").hasRole("ADMIN")


                // 5️⃣ Todo lo demás requiere login
                .anyRequest().authenticated()
            )

            .formLogin(form -> form
                .loginPage("/login")              // login personalizado
                .defaultSuccessUrl("/blog", true) // siempre al blog
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/blog")
                .permitAll()
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {

        return new InMemoryUserDetailsManager(

            User.withUsername("admin")
                .password(encoder.encode("admin123"))
                .roles("ADMIN")
                .build(),

            User.withUsername("user")
                .password(encoder.encode("user123"))
                .roles("USER")
                .build()
        );
    }
}
