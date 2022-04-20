package com.inepp.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @ClassName: HttpResp
 * @Author
 * @Date 2022/3/26
 */
@ApiModel(description = "http响应")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HttpResp {
    @ApiModelProperty(value = "响应代码")
    private int code;
    @ApiModelProperty(value = "响应代码")
    private String msg;
    @ApiModelProperty(value = "响应代码")
    private Object results;
    @ApiModelProperty(value = "响应代码")
    private LocalDate date;
}
