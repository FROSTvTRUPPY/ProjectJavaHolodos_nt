package com.myProject.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table("H_CONTROLLERS")
public class H_CONTR {
    @Id
    private int ID;
    private String NAME;
    private int MAGID;
}
