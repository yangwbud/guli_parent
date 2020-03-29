package com.yang.mvntest.entity;

import com.yang.mvntest.an.Cloumn;
import com.yang.mvntest.an.TName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TName
public class User {
    @Cloumn
    private String name;
    private Integer age;
    private String sex;


}
