package com.myProject.dto;

import lombok.*;
import org.springframework.data.annotation.Id;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class H_REQUESTS_Dto {

    @Id
    private int ID;
    private String IDMEH;
    private String IDMAG;
    private String MAGAdress;
    private String IDDIS;
    private String STATUS;
    private String DESC;
    private String NAME;
    private boolean CHEK;

}
