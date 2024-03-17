package org.youjhin.stamowebapp.services;

import org.springframework.stereotype.Service;
import org.youjhin.stamowebapp.models.HeadDiary;
import org.youjhin.stamowebapp.repository.HeadDiaryRepository;
import org.youjhin.stamowebapp.services.interfaces.DiaryService;

import java.util.List;

/**
 * Сервисная реализация для работы с дневниками головной боли.
 * Предоставляет функциональность для обработки запросов, связанных с дневниками пользователей.
 */
@Service
public class DiaryServiceImpl implements DiaryService {

    private final HeadDiaryRepository diaryRepository; // Репозиторий для доступа к данным дневников.

    /**
     * Конструктор для внедрения зависимости репозитория дневников.
     *
     * @param diaryRepository Репозиторий для работы с дневниками головной боли.
     */
    public DiaryServiceImpl(HeadDiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    /**
     * Возвращает список дневниковых записей по идентификатору чата пользователя.
     *
     * @param chatId Идентификатор чата, по которому осуществляется поиск дневниковых записей.
     * @return Список найденных записей дневника.
     */
    @Override
    public List<HeadDiary> getDiaryByChatId(Long chatId) {
        return diaryRepository.findByChatId(chatId);
    }
}