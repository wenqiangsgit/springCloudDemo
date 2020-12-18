package com.wenqiang.springcloud.serviceimpl;


import com.wenqiang.springcloud.dao.PaymentDao;
import com.wenqiang.springcloud.entities.Payment;
import com.wenqiang.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
