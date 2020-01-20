package com.study.practice.jan.jan14;

import com.study.common.util.CommonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 解压缩编码列表
 *
 * @author Daniel 2020/1/14
 */
public class LeetCode1313 {

    public static int[] decompressRLElist(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                count = nums[i];
            } else {
                for (int j = 0; j < count; j++) {
                    resultList.add(nums[i]);
                }
                count = 0;
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 1, 20, 2};
        int[] result = decompressRLElist(nums);
        CommonUtils.printArray(result);
    }
}
