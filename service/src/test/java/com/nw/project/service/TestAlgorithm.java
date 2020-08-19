package com.nw.project.service;

import java.util.HashMap;
import java.util.Map;

public class TestAlgorithm {

    public static void main() {
        int [] nums = new int[] {3,2,4};
        twoSum(nums,6);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            numMap.put(nums[i],i);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int rest = target - nums[i];
            if (numMap.containsKey(rest) && numMap.get(rest) != i)  {
                return new int[] {i,numMap.get(rest)};
            }
        }
        return null;
    }
}
