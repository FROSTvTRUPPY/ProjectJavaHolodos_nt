package com.myProject.dto;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class H_POSTS_Dto {

    private int ID;
    @NotEmpty(message = "Нужно название")
    private String NAME;
    private String DESC;
}
