package org.youjhin.stamowebapp.services;

import org.springframework.stereotype.Service;
import org.youjhin.stamowebapp.models.Users;
import org.youjhin.stamowebapp.repository.UsersRepository;
import org.youjhin.stamowebapp.services.interfaces.UsersService;

import java.util.List;

/**
 * Сервисная реализация для работы с пользователями.
 * Предоставляет методы для обработки запросов, связанных с пользователями, такие как получение всех пользователей и поиск пользователя по идентификатору чата.
 */
@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository; // Репозиторий для работы с данными пользователей.

    /**
     * Конструктор для внедрения зависимости репозитория пользователей.
     *
     * @param usersRepository Репозиторий для доступа к данным пользователей.
     */
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    /**
     * Получает список всех пользователей из базы данных.
     *
     * @return Список всех пользователей.
     */
    @Override
    public List<Users> getAllUsersFromBase() {
        return usersRepository.findAll();
    }

    /**
     * Ищет и возвращает пользователя по его идентификатору чата.
     *
     * @param chatId Идентификатор чата, по которому осуществляется поиск пользователя.
     * @return Найденный пользователь или null, если пользователь не найден.
     */
    @Override
    public Users getUserByChatId(Long chatId) {
        return usersRepository.getUserByChatId(chatId);
    }
}