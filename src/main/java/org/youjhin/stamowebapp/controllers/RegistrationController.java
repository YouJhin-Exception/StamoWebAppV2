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

@Controller
public class RegistrationController {


    private final DoctorsRepository doctorsRepository;
    private final PasswordEncoder passwordEncoder;


    public RegistrationController(DoctorsRepository doctorsRepository, PasswordEncoder passwordEncoder) {
        this.doctorsRepository = doctorsRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public ModelAndView registrationForm() {
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam("username") String username,
                               @RequestParam("password") String password) {
        Doctors doctor = new Doctors();
        doctor.setUsername(username);
        doctor.setPassword(passwordEncoder.encode(password));
        // Устанавливаем роль по умолчанию DOCTOR
        doctor.setRole(Role.DOCTOR);
        doctorsRepository.save(doctor);
        return "redirect:/login"; // Перенаправляем на страницу входа после регистрации
    }

}
