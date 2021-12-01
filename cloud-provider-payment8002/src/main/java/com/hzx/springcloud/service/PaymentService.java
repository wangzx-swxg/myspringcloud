package com.hzx.springcloud.service;

import com.hzx.springcloud.entity.Payment;
import com.hzx.springcloud.entity.ResultVO;
import org.apache.ibatis.annotations.Param;


public interface PaymentService {
    ResultVO addPayment(Payment payment);
    ResultVO queryById(@Param("id") int id);
}
