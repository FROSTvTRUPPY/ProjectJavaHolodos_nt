package com.myProject.config;

public enum H_Role {
    MAG ("Магазин"),
    MEH ("Механик"),
    DIS ("Диспетчер"),
    BIS ("Бухгалтерия");

    private String value;
    H_Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
