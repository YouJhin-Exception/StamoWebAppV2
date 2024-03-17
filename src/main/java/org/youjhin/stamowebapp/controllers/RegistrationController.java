package org.youjhin.stamowebapp.controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.youjhin.stamowebapp.enums.Role;
import org.youjhin.stamowebapp.models.Doctors;
import org.youjhin.stamowebapp.repository.DoctorsRepository;

/**
 * Контроллер для управления процессом регистрации новых пользователей.
 * Позволяет отображать форму регистрации и обрабатывать введенные данные пользователя.
 */
@Controller
public class RegistrationController {

    private final DoctorsRepository doctorsRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Конструктор класса, в котором происходит инициализация репозитория врачей и кодировщика паролей.
     *
     * @param doctorsRepository репозиторий для работы с данными врачей.
     * @param passwordEncoder кодировщик паролей для шифрования пароля перед сохранением.
     */
    public RegistrationController(DoctorsRepository doctorsRepository, PasswordEncoder passwordEncoder) {
        this.doctorsRepository = doctorsRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Обрабатывает GET-запросы на путь "/register" и отображает форму регистрации.
     *
     * @return объект ModelAndView для отображения страницы регистрации.
     */
    @GetMapping("/register")
    public ModelAndView registrationForm() {
        // Возвращаем представление с именем "register", которое должно быть отрендерено.
        return new ModelAndView("register");
    }

    /**
     * Обрабатывает POST-запросы на путь "/register", регистрируя нового пользователя с указанными данными.
     *
     * @param username имя пользователя, полученное из формы регистрации.
     * @param password пароль пользователя, полученный из формы регистрации.
     * @return строка перенаправления на страницу входа после успешной регистрации.
     */
    @PostMapping("/register")
    public String registerUser(@RequestParam("username") String username,
                               @RequestParam("password") String password) {
        Doctors doctor = new Doctors();
        doctor.setUsername(username);
        doctor.setPassword(passwordEncoder.encode(password)); // Кодирование пароля
        doctor.setRole(Role.DOCTOR); // Установка роли по умолчанию
        doctorsRepository.save(doctor); // Сохранение нового пользователя в базе данных
        return "redirect:/login"; // Перенаправление на страницу входа после регистрации
    }

}