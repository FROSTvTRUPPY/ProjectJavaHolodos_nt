package com.myProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table("H_REQUESTS")
public class H_REQUESTS {


    @Id
    @GeneratedValue
    private int ID;
    private int IDMEH;
    private int IDMAG;
    private int IDDIS;
    private String STATUS;
    private String DESC;
    private String NAME;
    private boolean CHEK;

}
