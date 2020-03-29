package com.yang.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class TeacherQuery implements Serializable{

    @ApiModelProperty(value = "教师名称")
    private String name;

    @ApiModelProperty(value = "教师头衔")
    private Integer level;

    @ApiModelProperty(value = "start_time",example = "2019-01-01 10:10:10")
    private String begin;

    @ApiModelProperty(value = "end_time",example = "2019-12-01 10:10:10")
    private String end;
}
