package com.hzx.springcloud.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Payment对象",description = "支付信息")
public class Payment {

    private int id;
    private String serial;
}
