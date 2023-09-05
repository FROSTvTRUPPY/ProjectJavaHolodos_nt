package com.myProject.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table("H_SENSOR_DATA")
public class H_SData {

    @Id
    private int ID;
    private int CONTROLLERID;
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
