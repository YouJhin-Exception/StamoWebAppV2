package org.youjhin.stamowebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.youjhin.stamowebapp.models.HeadDiary;

import java.util.List;

public interface HeadDiaryRepository extends JpaRepository<HeadDiary, Long> {
    List<HeadDiary> findByChatId(Long chatId);
}
