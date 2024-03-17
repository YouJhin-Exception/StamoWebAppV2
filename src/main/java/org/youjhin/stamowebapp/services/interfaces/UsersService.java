package org.youjhin.stamowebapp.services.interfaces;

import org.youjhin.stamowebapp.models.Users;

import java.util.List;

/**
 * Интерфейс сервиса для работы с пользователями.
 * Определяет методы для управления информацией о пользователях и их доступа к различным частям приложения.
 */
public interface UsersService {

    /**
     * Получает список всех пользователей из базы данных.
     *
     * @return Список всех зарегистрированных пользователей в системе.
     */
    List<Users> getAllUsersFromBase();

    /**
     * Ищет и возвращает пользователя по его идентификатору чата.
     *
     * @param chatId Идентификатор чата пользователя.
     * @return Объект Users, представляющий найденного пользователя, или null, если пользователь не найден.
     */
    Users getUserByChatId(Long chatId);
}