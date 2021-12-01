package com.hzx.springcloud.dao;


import com.hzx.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
    int addPayment(Payment payment);
    Payment queryById(int id);
}
