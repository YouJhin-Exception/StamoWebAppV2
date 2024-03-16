package org.youjhin.stamowebapp.services.interfaces;

import org.youjhin.stamowebapp.models.Users;

import java.util.List;

public interface UsersService {

    List<Users> getAllUsersFromBase();

    Users getUserByChatId(Long chatId);

}
