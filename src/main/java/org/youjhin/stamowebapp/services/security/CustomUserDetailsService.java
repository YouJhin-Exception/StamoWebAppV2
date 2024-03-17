package org.youjhin.stamowebapp.services.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.youjhin.stamowebapp.repository.DoctorsRepository;

/**
 * Сервис для загрузки пользовательских данных по имени пользователя.
 * Реализует интерфейс UserDetailsService, необходимый для интеграции с Spring Security.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final DoctorsRepository doctorsRepository; // Репозиторий для работы с данными о докторах.

    /**
     * Конструктор для внедрения зависимости репозитория докторов.
     *
     * @param doctorsRepository Репозиторий для доступа к данным докторов.
     */
    public CustomUserDetailsService(DoctorsRepository doctorsRepository) {
        this.doctorsRepository = doctorsRepository;
    }

    /**
     * Загружает пользователя по его имени пользователя.
     *
     * @param username Имя пользователя, используемое для поиска в базе данных.
     * @return Детализированная информация о пользователе, реализующая интерфейс UserDetails.
     * @throws UsernameNotFoundException Если пользователь с таким именем не найден.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return doctorsRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }
}
