package com.hzx.springcloud.controller;

import com.hzx.springcloud.entity.Payment;
import com.hzx.springcloud.entity.ResultStatus;
import com.hzx.springcloud.entity.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/order")
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;
    @PostMapping("/payment/create")
    public ResultVO<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, ResultVO.class);
    }
    // getForObject 返回的时json对象
    @GetMapping("/payment/get/{id}")
    public ResultVO<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, ResultVO.class);
    }
//    getForEntity返回的是ResponseEntity对象，有状态码、网址等重要信息
    @GetMapping("/payment/get2/{id}")
    public ResultVO<Payment> getPayment2(@PathVariable("id") Long id) {
        ResponseEntity<ResultVO> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, ResultVO.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            log.info(entity.getHeaders() + "\t" + entity.getHeaders());
            return entity.getBody();
        } else {
            return new ResultVO(ResultStatus.NO,"失败");
        }
    }

    // ====================> zipkin+sleuth
    @GetMapping("/payment/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject(PAYMENT_URL+"/payment/zipkin/", String.class);
        return result;
    }
}
