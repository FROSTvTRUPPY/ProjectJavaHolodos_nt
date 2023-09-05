package com.myProject.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table("H_USERS")
public class H_USERS {
    @Id
    private int ID;
    private String LOGG;
    private String PASS;
    private int ID_POST;
    private String NAME_FIRST;
    private String NAME_LAST;
    private String PHONENUM;
    private boolean STAT;
}

