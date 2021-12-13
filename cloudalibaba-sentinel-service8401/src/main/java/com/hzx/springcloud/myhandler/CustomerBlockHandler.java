package com.hzx.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hzx.springcloud.entity.ResultVO;

/**
 * @auther zzyy
 * @create 2020-02-25 15:32
 */
public class CustomerBlockHandler {


    public static ResultVO handlerException(BlockException exception) {
        return new ResultVO(4444, "按客戶自定义,global handlerException----1");
    }


    public static ResultVO handlerException2(BlockException exception) {
        return new ResultVO(4444, "按客戶自定义,global handlerException----2");
    }
}
