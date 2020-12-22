package com.wenqiang.springcloud.controller;

import com.wenqiang.springcloud.entities.CommonResult;
import com.wenqiang.springcloud.entities.Payment;
import com.wenqiang.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment>get(@PathVariable Long id){
        return paymentFeignService.getPaymentById(id);
    }


    @GetMapping("/payment/zipkin")
    public String zipkin(){
        return paymentFeignService.zipkin();
    }

}
