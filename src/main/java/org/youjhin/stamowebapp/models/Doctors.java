package org.youjhin.stamowebapp.models;

import jakarta.persistence.*;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.youjhin.stamowebapp.enums.Role;

import java.util.Collection;
import java.util.Collections;


/**
 * Класс сущности "Врачи", представляющий пользователя системы.
 * Реализует интерфейс UserDetails для интеграции с Spring Security.
 */
@Setter // Генерация сеттеров для всех полей класса с помощью библиотеки Lombok
@Entity // Указывает, что класс является сущностью JPA
public class Doctors implements UserDetails {

    @Id // Помечает поле как первичный ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоматическая генерация значения идентификатора
    private Long id; // Идентификатор врача

    private String username; // Имя пользователя
    private String password; // Пароль пользователя

    @Enumerated(EnumType.STRING) // Указывает, что перечисление должно быть сохранено в БД как строка
    private Role role; // Роль пользователя в системе

    /**
     * Возвращает коллекцию ролей пользователя, необходимую для Spring Security.
     *
     * @return Коллекция авторизационных ролей пользователя.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(role); // Возвращаем роль пользователя в виде коллекции
    }

    @Override
    public String getPassword() {
        return password; // Возвращает пароль пользователя
    }

    @Override
    public String getUsername() {
        return username; // Возвращает имя пользователя
    }

    // Ниже перечисленные методы возвращают true, указывая на то, что аккаунт пользователя всегда валиден.
    // В реальном приложении эти значения могут зависеть от состояния сущности.
    @Override
    public boolean isAccountNonExpired() {
        return true; // Аккаунт не истек
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Аккаунт не заблокирован
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Учетные данные не истекли
    }

    @Override
    public boolean isEnabled() {
        return true; // Пользователь активен
    }
}