package com.wenqiang.springcloud.service;

import com.wenqiang.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {


    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
