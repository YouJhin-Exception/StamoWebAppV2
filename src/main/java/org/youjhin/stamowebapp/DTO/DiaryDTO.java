package org.youjhin.stamowebapp.DTO;

import lombok.Getter;
import org.youjhin.stamowebapp.models.HeadDiary;

/**
 * Класс DTO (Data Transfer Object) для передачи данных о дневнике головной боли.
 * Используется для передачи данных между слоями приложения, а также для форматирования и представления данных в виде, удобном для пользователя.
 */
@Getter // Аннотация Lombok, автоматически генерирующая геттеры для всех полей класса
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

    /**
     * Конструктор класса, инициализирующий поля объекта на основе данных из экземпляра HeadDiary.
     *
     * @param diary Экземпляр HeadDiary, содержащий данные для инициализации объекта DiaryDTO.
     */
    public DiaryDTO(HeadDiary diary) {
        this.chatId = diary.getChatId();
        // dateOfFilling устанавливается в контроллере
        this.howMuchHurtScale = diary.getHowMuchHurtScale();
        this.natureHeadache = diary.getNatureHeadache();
        this.areaHurt = diary.getAreaHurt();
        this.werePain = diary.getWerePain();
        this.symptoms = diary.getSymptoms();
        this.relieveAttack = diary.getRelieveAttack();
        this.preventionHeadache = diary.getPreventionHeadache();
        this.takeMedication = diary.getTakeMedication();
    }

    /**
     * Метод для установки даты заполнения дневника.
     *
     * @param dateOfFilling Строковое представление даты заполнения дневника.
     */
    public void setDateOfFilling(String dateOfFilling) {
        this.dateOfFilling = dateOfFilling;
    }
}
