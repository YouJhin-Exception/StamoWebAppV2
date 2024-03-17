package org.youjhin.stamowebapp.cofiguration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.youjhin.stamowebapp.enums.Role;

/**
 * Конфигурационный класс для настройки безопасности веб-приложения.
 * Он включает в себя настройки Web Security и Method Security для управления доступом к ресурсам приложения.
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration {

    /**
     * Настраивает цепочку фильтров безопасности для определения правил доступа к различным частям приложения.
     *
     * @param httpSecurity конфигуратор безопасности HTTP.
     * @return сконфигурированный объект SecurityFilterChain.
     * @throws Exception может бросать исключение при настройке.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // Отключение CSRF защиты для упрощения разработки
                .csrf(AbstractHttpConfigurer::disable)
                // Настройка правил доступа
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry
                        // Доступ к "/allUsers" и "/diaries/**" только у пользователей с ролью DOCTOR
                        .requestMatchers("/allUsers", "/diaries/**").hasRole(Role.DOCTOR.name())
                        // Страницы "/login" и "/register" доступны всем пользователям
                        .requestMatchers("/login", "/register").permitAll())

                // Настройка формы логина
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/allUsers", true)
                        .permitAll())

                // Настройка выхода из системы
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")
                        .permitAll());

                 // если понадобится ограничение прав
//              .exceptionHandling(exception -> exception
//                        .accessDeniedPage("/access-denied"))

        return httpSecurity.build();
    }

    /**
     * Создает бин для шифрования паролей с использованием BCrypt.
     *
     * @return объект PasswordEncoder для шифрования паролей.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}