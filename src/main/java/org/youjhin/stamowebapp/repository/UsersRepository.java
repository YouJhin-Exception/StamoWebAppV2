package org.youjhin.stamowebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.youjhin.stamowebapp.models.Users;

/**
 * Репозиторий для работы с пользователями.
 * Предоставляет интерфейс для стандартных операций CRUD над сущностью Users,
 * а также включает специализированный метод для поиска пользователя по идентификатору чата.
 */
public interface UsersRepository extends JpaRepository<Users, Long> {

    /**
     * Поиск пользователя по идентификатору чата.
     *
     * @param chatId Идентификатор чата, по которому осуществляется поиск.
     * @return Объект Users, соответствующий заданному идентификатору чата.
     */
    Users getUserByChatId(Long chatId);
}