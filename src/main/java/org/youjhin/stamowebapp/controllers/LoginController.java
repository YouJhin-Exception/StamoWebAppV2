package org.youjhin.stamowebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Контроллер для управления процессом аутентификации пользователя.
 * Отвечает за отображение страницы входа в систему.
 */
@Controller
public class LoginController {

    /**
     * Обрабатывает GET-запросы на путь "/login".
     *
     * @return имя представления (view) для отображения страницы входа.
     */
    @GetMapping("/login")
    public String login() {
        // Возвращает имя представления страницы входа.
        // Фреймворк ищет файл представления с этим именем (например, login.html) в папке с ресурсами.
        return "login";
    }

}
