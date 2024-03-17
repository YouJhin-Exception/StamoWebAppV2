package org.youjhin.stamowebapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.sql.Timestamp;


/**
 * Сущность "Дневник головной боли", представляющая запись в дневнике пользователя.
 * Содержит детальную информацию о каждом случае головной боли.
 */
@Getter // Генерирует геттеры для всех полей класса
@Entity(name = "headDiaryDataTable") // Определяет класс как сущность JPA и указывает имя таблицы в базе данных
public class HeadDiary {

    @Id // Указывает, что поле является первичным ключом
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Конфигурация генерации уникального значения для первичного ключа
    private long diaryId; // Уникальный идентификатор записи в дневнике

    private long chatId; // Идентификатор чата пользователя, к которому относится эта запись

    private Timestamp dateOfFilling; // Дата и время заполнения записи

    private String howMuchHurtScale;

    private String natureHeadache;

    private String areaHurt;

    private String werePain;

    private String symptoms;

    private String relieveAttack;

    private String preventionHeadache;

    private String takeMedication;
}
