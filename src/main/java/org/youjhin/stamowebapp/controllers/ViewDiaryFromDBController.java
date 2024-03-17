package org.youjhin.stamowebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.youjhin.stamowebapp.DTO.DiaryDTO;
import org.youjhin.stamowebapp.models.HeadDiary;
import org.youjhin.stamowebapp.models.Users;
import org.youjhin.stamowebapp.services.interfaces.DiaryService;
import org.youjhin.stamowebapp.services.interfaces.UsersService;

import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Контроллер для отображения дневниковых записей из базы данных.
 * Позволяет пользователям просматривать дневниковые записи, связанные с их учетной записью.
 */
@Controller
public class ViewDiaryFromDBController {

    private final DiaryService diaryService;
    private final UsersService usersService;

    /**
     * Конструктор для внедрения зависимостей сервисов обработки дневников и пользователей.
     *
     * @param diaryService сервис для работы с дневниками.
     * @param usersService сервис для работы с пользователями.
     */
    public ViewDiaryFromDBController(DiaryService diaryService, UsersService usersService) {
        this.diaryService = diaryService;
        this.usersService = usersService;
    }

    /**
     * Метод для обработки GET-запроса на получение страницы дневников по идентификатору чата пользователя.
     *
     * @param chatId идентификатор чата, для которого нужно найти дневниковые записи.
     * @param model модель для передачи данных в представление.
     * @return имя представления для отображения страницы с дневниками.
     */
    @GetMapping("/diaries/{chatId}")
    public String viewDiariesByChatId(@PathVariable Long chatId, Model model) {
        // Получение пользователя по идентификатору чата
        Users user = usersService.getUserByChatId(chatId);
        // Получение списка дневниковых записей пользователя
        List<HeadDiary> diaries = diaryService.getDiaryByChatId(chatId);

        // Форматирование даты каждой записи и создание DTO для передачи в представление
        List<DiaryDTO> formattedDiaries = diaries.stream().map(diary -> {
            DiaryDTO diaryDTO = new DiaryDTO(diary);
            String formattedDate = diary.getDateOfFilling().toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            diaryDTO.setDateOfFilling(formattedDate);
            return diaryDTO;
        }).toList();

        // Добавление пользователя и его дневниковых записей в модель
        model.addAttribute("user", user);
        model.addAttribute("diaries", formattedDiaries);
        // Возвращение имени представления для отображения страницы дневников
        return "diaries";
    }

}
