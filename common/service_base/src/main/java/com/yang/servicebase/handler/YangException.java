package com.yang.servicebase.handler;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YangException extends RuntimeException {

    @ApiModelProperty(value = "status code")
    private Integer code;

    private String msg;

}
