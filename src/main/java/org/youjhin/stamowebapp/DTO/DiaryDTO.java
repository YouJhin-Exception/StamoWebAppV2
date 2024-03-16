package org.youjhin.stamowebapp.DTO;

import lombok.Getter;
import org.youjhin.stamowebapp.models.HeadDiary;

@Getter
public class DiaryDTO {
    private long chatId;

    private String dateOfFilling;

    private String howMuchHurtScale;

    private String natureHeadache;

    private String areaHurt;

    private String werePain;

    private String symptoms;

    private String relieveAttack;

    private String preventionHeadache;

    private String takeMedication;

    public DiaryDTO(HeadDiary diary) {

        this.chatId = diary.getChatId();
        //  dateOfFilling установлен в контроллере
        this.howMuchHurtScale = diary.getHowMuchHurtScale();
        this.natureHeadache = diary.getNatureHeadache();
        this.areaHurt = diary.getAreaHurt();
        this.werePain = diary.getWerePain();
        this.symptoms = diary.getSymptoms();
        this.relieveAttack = diary.getRelieveAttack();
        this.preventionHeadache = diary.getPreventionHeadache();
        this.takeMedication = diary.getTakeMedication();
    }

    public void setDateOfFilling(String dateOfFilling) {
        this.dateOfFilling = dateOfFilling;
    }
}
