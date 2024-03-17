package org.youjhin.stamowebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.youjhin.stamowebapp.models.Doctors;

import java.util.Optional;

/**
 * Репозиторий для работы с данными докторов.
 * Предоставляет стандартные операции над сущностями Doctors, такие как сохранение, удаление и поиск, а также позволяет определять собственные методы запросов.
 */
public interface DoctorsRepository extends JpaRepository<Doctors, Long> {

    /**
     * Поиск доктора по имени пользователя.
     *
     * @param username Имя пользователя, по которому осуществляется поиск.
     * @return Optional с объектом Doctors, если доктор с таким именем пользователя найден, и пустой Optional в противном случае.
     */
    Optional<Doctors> findByUsername(String username);
}