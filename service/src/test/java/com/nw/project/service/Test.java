package com.nw.project.service;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

@Service
public class Test {
    @Autowired
    private PaymentRemoteService paymentRemoteService;

    public List<String> getAvailablePayMentType(List<String> payMentTypeList) {
            if (CollectionUtils.isEmpty(payMentTypeList)) {
                return ListUtils.EMPTY_LIST;
            }
            Map<String,ConsultResult> resultMap = new ConcurrentHashMap<>();
            CountDownLatch countDownLatch = new CountDownLatch(payMentTypeList.size());
            for (String type : payMentTypeList) {
                checkPayMentTypeIsAvailable(countDownLatch,type,resultMap);
            }

            try {
                countDownLatch.await();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return new ArrayList<>(resultMap.keySet());
        }

        @Async("asyncThread")
        public void checkPayMentTypeIsAvailable(CountDownLatch countDownLatch, String payMentType,Map<String,ConsultResult> resultMap) {
            if (StringUtils.isBlank(payMentType)) {
                countDownLatch.countDown();
                return;
            }
            try {
                ConsultResult consultResult = paymentRemoteService.isEnable(payMentType);
                if (consultResult.getIsEnable()) {
                    resultMap.put(payMentType,consultResult);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            countDownLatch.countDown();
        }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            numMap.put(nums[i],i);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int rest = target - nums[i];
            if (null != numMap.get(rest)) {
                return new int [] {i,numMap.get(rest)};
            }
        }
        return null;
    }
}
