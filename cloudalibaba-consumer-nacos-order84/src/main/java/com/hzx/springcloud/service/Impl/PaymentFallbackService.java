package com.hzx.springcloud.service.Impl;

import com.hzx.springcloud.entity.Payment;
import com.hzx.springcloud.entity.ResultVO;
import com.hzx.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public ResultVO<Payment> paymentSQL(Long id) {
        return new ResultVO<>(4444,"服务降级返回，---paymentservice",new Payment(id,"errorSerial"));
    }
}
