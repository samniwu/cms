package com.nw.project.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class PaymentRemoteService {

    public ConsultResult isEnable(String paymengType) {
        boolean isEnable = false;
        String errorCode = StringUtils.EMPTY;
        //业务处理判断支付方式可用性
        return new ConsultResult(isEnable,errorCode);
    }
}
