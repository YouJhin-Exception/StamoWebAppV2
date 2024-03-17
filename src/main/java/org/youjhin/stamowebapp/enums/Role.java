package org.youjhin.stamowebapp.enums;

import org.springframework.security.core.GrantedAuthority;

/**
 * Перечисление, представляющее роли пользователей в системе.
 * Используется для определения уровней доступа в рамках Spring Security.
 */
public enum Role implements GrantedAuthority {

    ADMIN("ROLE_ADMIN"), // Роль администратора с расширенными правами доступа
    DOCTOR("ROLE_DOCTOR"); // Роль врача с ограниченными правами доступа

    private final String authority; // Поле для хранения строки, представляющей роль в системе безопасности

    /**
     * Конструктор для инициализации объекта роли с заданным названием роли.
     *
     * @param authority Название роли, используемое в системе безопасности.
     */
    Role(String authority) {
        this.authority = authority;
    }

    /**
     * Метод, переопределенный из интерфейса GrantedAuthority.
     * Возвращает название роли, которое используется в проверках прав доступа.
     *
     * @return Строковое представление роли, которое может быть использовано в проверках безопасности.
     */
    @Override
    public String getAuthority() {
        return authority;
    }
}
