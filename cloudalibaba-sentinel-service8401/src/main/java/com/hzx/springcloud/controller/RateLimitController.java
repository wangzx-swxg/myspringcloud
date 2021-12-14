package com.hzx.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hzx.springcloud.entity.Payment;
import com.hzx.springcloud.entity.ResultVO;
import com.hzx.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public ResultVO byResource() {
        return new ResultVO(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
    }

    public ResultVO handleException(BlockException exception) {
        return new ResultVO(444, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException1")
    public ResultVO byUrl() {
        return new ResultVO(200, "按url限流测试OK", new Payment(2020L, "serial002"));
    }


    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public ResultVO customerBlockHandler() {
        return new ResultVO(200, "按客戶自定义", new Payment(2020L, "serial003"));
    }
}
