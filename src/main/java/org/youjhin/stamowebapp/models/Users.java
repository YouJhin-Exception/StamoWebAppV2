package org.youjhin.stamowebapp.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.sql.Timestamp;


@Getter
@Entity(name = "usersDataTable")
public class Users {

    @Id
    private long chatId;

    private String firstName;

    private String lastName;

    private String userName;

    private Timestamp registeredAt;

    private String lifeLastName;

    private String lifeFirstName;

    private String age;

}
