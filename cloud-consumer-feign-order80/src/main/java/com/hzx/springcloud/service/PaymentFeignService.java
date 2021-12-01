package com.hzx.springcloud.service;

import com.hzx.springcloud.entity.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("/payment/get/{id}")
    public ResultVO queryById(@PathVariable("id") int id);
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout();
}
