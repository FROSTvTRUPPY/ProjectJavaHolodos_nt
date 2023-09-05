package com.myProject.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.data.annotation.Id;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class H_SDate_Dto {

    @Id
    private int ID;
    @NotEmpty(message = "Название контроллера не должно быть пустым")
    private String NAME;
    private double TMP1;
    private double TMP2;
    private double TMP3;
    private double TMP4;
    private double TMP5;
    private double BAR1;
    private double BAR2;
    private double BAR3;
    private double WAT1;
    private double WAT2;
    private double WAT3;
    private boolean BOOL1;
    private boolean BOOL2;
    private boolean BOOL3;
    private boolean STATUS;

}
