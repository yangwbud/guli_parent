package com.yang.eduservice.entity;

import lombok.Getter;

public enum Country_Enum {
    SPRING(1,"春季"),SUMMER(2,"夏季"),AUTUMN(3,"秋季"),WINTER(4,"冬季");

    @Getter private Integer id;
    @Getter private String name;

    Country_Enum(Integer id,String name){
        this.id = id;
        this.name = name;
    }

    public static Country_Enum forEach_Enum(int index){
        Country_Enum[] values = Country_Enum.values();
        for (Country_Enum value : values) {
            if (index==value.getId()){
                return value;
            }
        }
        return null;
    }
}
