package org.youjhin.stamowebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.youjhin.stamowebapp.services.interfaces.UsersService;

/**
 * Контроллер для отображения списка всех пользователей из базы данных.
 * Предоставляет функциональность для получения информации о пользователях и передачи ее в представление.
 */
@Controller
public class ViewUsersFromDBController {

    private final UsersService usersService; // Сервис для работы с пользователями

    /**
     * Конструктор для внедрения зависимости сервиса пользователей.
     *
     * @param usersService сервис, предоставляющий доступ к операциям с пользователями.
     */
    public ViewUsersFromDBController(UsersService usersService) {
        this.usersService = usersService;
    }

    /**
     * Метод обрабатывает GET-запрос на путь "/allUsers" и возвращает представление со списком всех пользователей.
     *
     * @param model объект Model, используемый для добавления атрибутов, передаваемых в представление.
     * @return строка, указывающая на имя представления (view), которое должно быть отрендерено.
     */
    @GetMapping(value = "/allUsers")
    public String getTable(Model model) {
        // Добавление списка всех пользователей в модель
        model.addAttribute("users", usersService.getAllUsersFromBase());
        // Возвращение имени представления "allUsers", которое будет отображать список пользователей
        return "allUsers";
    }
}