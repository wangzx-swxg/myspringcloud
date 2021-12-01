package com.hzx.springcloud.controller;

import com.hzx.springcloud.entity.Payment;
import com.hzx.springcloud.entity.ResultVO;
import com.hzx.springcloud.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/payment")
@Api(value = "微服务提供支付模块",tags = "支付管理")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @ApiOperation("注册支付信息接口")
    @PostMapping("/create")
    public ResultVO add(@RequestBody Payment payment) {
        ResultVO resultVO = paymentService.addPayment(payment);
        return resultVO;
    }

    @GetMapping("/get/{id}")
    @ApiOperation("查询支付信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int",name = "id", value = "支付ID",required = true),
    })
    public ResultVO queryById(@PathVariable("id") int id) {
        ResultVO resultVO = paymentService.queryById(id);
        return resultVO;
    }
}

