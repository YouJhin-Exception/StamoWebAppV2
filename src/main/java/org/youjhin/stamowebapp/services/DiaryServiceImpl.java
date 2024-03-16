package org.youjhin.stamowebapp.services;

import org.springframework.stereotype.Service;
import org.youjhin.stamowebapp.models.HeadDiary;
import org.youjhin.stamowebapp.repository.HeadDiaryRepository;
import org.youjhin.stamowebapp.services.interfaces.DiaryService;

import java.util.List;

@Service
public class DiaryServiceImpl implements DiaryService {

    private final HeadDiaryRepository diaryRepository;


    public DiaryServiceImpl(HeadDiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    @Override
    public List<HeadDiary> getDiaryByChatId(Long chatId) {
        return diaryRepository.findByChatId(chatId);
    }
}
