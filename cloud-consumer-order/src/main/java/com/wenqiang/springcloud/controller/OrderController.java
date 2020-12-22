package com.wenqiang.springcloud.controller;

import com.wenqiang.springcloud.entities.CommonResult;
import com.wenqiang.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SuppressWarnings("all")
@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String url="http://CLOUD-PAYMENT-SERVICE/payment";

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        log.info("****新增****");
        return restTemplate.postForObject(url+"/create",payment, CommonResult.class);
    }
    //http://localhost:8001/payment/get/32
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment>get(@PathVariable Long id){
        return restTemplate.getForObject(url+"/get/"+id,CommonResult.class);
    }

    // ====================> zipkin+sleuth
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject(url+"/payment/zipkin", String.class);
        return result;
    }


}
