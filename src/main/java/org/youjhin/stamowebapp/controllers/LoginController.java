package org.youjhin.stamowebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Контроллер для управления процессом аутентификации пользователя в Spring MVC приложении.
 * Отвечает за отображение страницы входа и обработку ошибок аутентификации.
 */
@Controller
public class LoginController {

    /**
     * Обрабатывает GET-запросы на путь "/login", отображая страницу входа.
     * Если в запросе присутствует параметр 'error', добавляет в модель атрибут,
     * указывающий на наличие ошибки аутентификации, что позволяет отобразить
     * соответствующее сообщение об ошибке на странице входа.
     *
     * @param error Опциональный параметр запроса, указывающий на наличие ошибки аутентификации.
     * @param model Объект модели, используемый для передачи атрибутов в представление.
     * @return Имя представления (view) для отображения страницы входа. Фреймворк автоматически
     *         ищет файл представления с этим именем (например, login.html) в папке ресурсов.
     */
    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        // Проверка наличия параметра 'error' в запросе
        if (error != null) {
            // Добавление атрибута 'loginError' в модель, если обнаружена ошибка аутентификации
            model.addAttribute("loginError", true);
        }
        // Возврат имени представления страницы входа
        return "login";
    }

}
