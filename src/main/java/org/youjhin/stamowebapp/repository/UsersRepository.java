package org.youjhin.stamowebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.youjhin.stamowebapp.models.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users getUserByChatId(Long chatId);
}
