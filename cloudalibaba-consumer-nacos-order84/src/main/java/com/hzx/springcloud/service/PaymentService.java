package com.hzx.springcloud.service;


import com.hzx.springcloud.entity.Payment;
import com.hzx.springcloud.entity.ResultVO;
import com.hzx.springcloud.service.Impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService {
    @GetMapping(value = "/paymentSQL/{id}")
    public ResultVO<Payment> paymentSQL(@PathVariable("id") Long id);
}
