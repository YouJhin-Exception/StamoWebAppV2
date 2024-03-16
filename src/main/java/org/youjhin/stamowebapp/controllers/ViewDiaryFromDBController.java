package org.youjhin.stamowebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.youjhin.stamowebapp.DTO.DiaryDTO;
import org.youjhin.stamowebapp.models.HeadDiary;
import org.youjhin.stamowebapp.models.Users;
import org.youjhin.stamowebapp.services.interfaces.DiaryService;
import org.youjhin.stamowebapp.services.interfaces.UsersService;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class ViewDiaryFromDBController {

    private final DiaryService diaryService;
    private final UsersService usersService;

    //@Autowired
    public ViewDiaryFromDBController(DiaryService diaryService, UsersService usersService) {
        this.diaryService = diaryService;
        this.usersService = usersService;
    }

    @GetMapping("/diaries/{chatId}")
    public String viewDiariesByChatId(@PathVariable Long chatId, Model model) {

        Users user = usersService.getUserByChatId(chatId);
        List<HeadDiary> diaries = diaryService.getDiaryByChatId(chatId);

        List<DiaryDTO> formattedDiaries = diaries.stream().map(diary -> {
            DiaryDTO diaryDTO = new DiaryDTO(diary);
            String formattedDate = diary.getDateOfFilling().toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            diaryDTO.setDateOfFilling(formattedDate);
            return diaryDTO;
        }).toList();

        model.addAttribute("user", user);
        model.addAttribute("diaries", formattedDiaries);
        return "diaries";
    }


}
