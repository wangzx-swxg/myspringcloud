package com.hzx.springcloud.service.Impl;

import com.hzx.springcloud.dao.PaymentDao;
import com.hzx.springcloud.entity.Payment;
import com.hzx.springcloud.entity.ResultStatus;
import com.hzx.springcloud.entity.ResultVO;
import com.hzx.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;
    @Value("${server.port}")
    private String serverPort;
    @Override
    public ResultVO addPayment(Payment payment) {
        int i = paymentDao.addPayment(payment);
        if (i>0) {
            log.info("插入数据库成功:" + i);
            return new ResultVO(ResultStatus.OK,"success,serverPort:" + serverPort,i);
        }
        return new ResultVO(ResultStatus.NO,"fail");

    }

    @Override
    public ResultVO queryById(int id) {
        Payment payment = paymentDao.queryById(id);
        if (payment != null) {
            log.info("查询结果：" + payment);
            return new ResultVO(ResultStatus.OK,"success,serverPort:" + serverPort,payment);
        }
        return new ResultVO(ResultStatus.NO,"fail");
    }
}
