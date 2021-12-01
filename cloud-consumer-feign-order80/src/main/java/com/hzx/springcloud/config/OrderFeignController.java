package com.hzx.springcloud.config;


import com.hzx.springcloud.entity.Payment;
import com.hzx.springcloud.entity.ResultVO;
import com.hzx.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @auther zzyy
 * @create 2020-02-20 0:05
 */
@RestController
@RequestMapping("order")
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/payment/get/{id}")
    public ResultVO<Payment> getPaymentById(@PathVariable("id") int id) {
        return paymentFeignService.queryById(id);
    }

//    @GetMapping(value = "/payment/feign/timeout")
//    public String paymentFeignTimeout() {
//        // OpenFeign客户端一般默认等待1秒钟
//        return paymentFeignService.paymentFeignTimeout();
//    }
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout() {
        return paymentFeignService.paymentFeignTimeout();
    }
}
