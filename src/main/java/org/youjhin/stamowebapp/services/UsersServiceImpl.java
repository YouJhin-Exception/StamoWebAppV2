package org.youjhin.stamowebapp.services;

import org.springframework.stereotype.Service;
import org.youjhin.stamowebapp.models.Users;
import org.youjhin.stamowebapp.repository.UsersRepository;
import org.youjhin.stamowebapp.services.interfaces.UsersService;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;


    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<Users> getAllUsersFromBase() {
        return usersRepository.findAll();
    }

    @Override
    public Users getUserByChatId(Long chatId) {
        return usersRepository.getUserByChatId(chatId);
    }
}
