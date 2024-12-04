package org.educadventista.Sistema.GE.config;

import org.educadventista.Sistema.GE.service.JwtUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Bean para o PasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Bean para o AuthenticationManager
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }

    // Bean para o UserDetailsService
    @Bean
    public UserDetailsService userDetailsService() {
        return new JwtUserDetailsService(); // Supondo que você tenha a implementação JwtUserDetailsService
    }

    // Configuração de segurança com SecurityFilterChain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authz -> authz
                        .requestMatchers("/api/**", "/swagger-ui/**", "/v3/api-docs/**", "/authenticate", "/register").permitAll()  // Permitir acesso sem autenticação
                        .anyRequest().authenticated() // Exigir autenticação para as outras rotas
                ); // Desativa o login baseado em formulário

        return http.build(); // Retorna a configuração de segurança
    }
}
