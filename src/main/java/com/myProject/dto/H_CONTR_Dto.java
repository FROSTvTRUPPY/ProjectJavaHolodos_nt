package com.myProject.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.data.annotation.Id;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class H_CONTR_Dto {

    @Id
    private int ID;
    @NotEmpty(message = "Название контроллера не должно быть пустым")
    private String NAME;
    @NotEmpty(message = "Нужен магазин")
    @Digits(message = "", integer = 10, fraction = 0)
    private int MAGID;
}
