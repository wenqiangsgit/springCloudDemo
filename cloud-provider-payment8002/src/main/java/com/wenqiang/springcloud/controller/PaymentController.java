package com.wenqiang.springcloud.controller;

import com.wenqiang.springcloud.entities.CommonResult;
import com.wenqiang.springcloud.entities.Payment;
import com.wenqiang.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("all")
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    //新增
    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        if(result>0){
            return new CommonResult(200,"新增成功！8002",payment);
        }
        return new CommonResult(404,"新增失败！",null);
    }
    //通过id进行查询
    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("****查询结果为：****");
        if(payment!=null){
            return new CommonResult(200,"查询成功8002",payment);
        }
        return new CommonResult(444,"查询失败",null);
    }

}