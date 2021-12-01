package com.hzx.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO<T> {
    private int code;
    private String msg;
    private T data;

    public ResultVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
