package org.youjhin.stamowebapp.services.interfaces;

import org.youjhin.stamowebapp.models.HeadDiary;

import java.util.List;

public interface DiaryService {
    List<HeadDiary> getDiaryByChatId(Long chatId);
}
