package com.myProject.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class H_USERS_Dto {

    private int ID;
    @NotEmpty(message = "Нужны логин и пароль")
    private String LOGG, PASS;
    @Digits(message = "укажите тип учетной записи", integer = 4, fraction = 0)
    private String ID_POST;
    private String NAME_FIRST;
    private String NAME_LAST;
    private String PHONENUM;
    private boolean STAT;

}
