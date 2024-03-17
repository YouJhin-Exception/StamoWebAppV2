package org.youjhin.stamowebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.youjhin.stamowebapp.models.HeadDiary;

import java.util.List;

/**
 * Репозиторий для работы с записями дневников головной боли.
 * Обеспечивает доступ к базовым операциям CRUD для сущности HeadDiary и позволяет добавлять специфичные для домена методы запросов.
 */
public interface HeadDiaryRepository extends JpaRepository<HeadDiary, Long> {

    /**
     * Находит все записи дневника по идентификатору чата пользователя.
     * Этот метод позволяет извлекать все записи в дневнике, связанные с конкретным пользователем, что может быть полезно для отображения истории записей или для аналитических целей.
     *
     * @param chatId Идентификатор чата пользователя, для которого нужно найти записи дневника.
     * @return Список записей дневника, соответствующих указанному идентификатору чата.
     */
    List<HeadDiary> findByChatId(Long chatId);
}
