package com.study.leetcode.sort;

import com.study.common.util.CommonUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1636. 按照频率将数组升序排序
 * <p>
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/17 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_1636_按照频率将数组升序排序 {

    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            if (freq.get(num) != null) {
                freq.put(num, freq.get(num) + 1);
            } else {
                freq.put(num, 1);
            }
        }

        Integer[] ans = new Integer[nums.length];
        int index = 0;
        for (int num : nums) {
            ans[index++] = num;
        }
        Arrays.sort(ans, (i , j) -> {
            if (freq.get(i) < freq.get(j)) {
                return -1;
            } else if (freq.get(i) > freq.get(j)) {
                return 1;
            } else {
                // 如果元素的频率相等，那么按元素本身降序排序
                return j - i;
            }
        });

        for (int i = 0; i < ans.length; i++) {
            nums[i] = ans[i];
        }

        return nums;
    }

    public static int[] frequencySort2(int[] nums) {
        int[] freq = new int[201];
        for (int num : nums) {
            freq[num + 100]++;
        }

        for (int i = 0; i < nums.length; i++){
            nums[i] = 201 * freq[nums[i] + 100] - nums[i] + 100;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            nums[i] = 100 - nums[i] % 201;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3};
        CommonUtils.printArray(frequencySort(nums));
    }
}
