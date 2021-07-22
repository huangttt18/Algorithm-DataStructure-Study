package com.study.leetcode.everyday;

import java.util.Arrays;

/**
 * 1838. 最高频元素的频数
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel - 2021/7/19</a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_1838_最高频元素的频数 {

    public static int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        // 计算前缀和
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        // 二分查找
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int l = 0, r = i, res = -1;
            while (l <= r) {
                int mid = (l + r) >>> 1;
                if (nums[i] * (i - mid + 1) - (prefixSum[i] - (mid <= 0 ? 0 : prefixSum[mid - 1])) <= k) {
                    r = mid - 1;
                    res = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (res != -1) {
                ans = Math.max(ans, i - res + 1);
            }
        }
        return ans;
    }

    /**
     * 滑动窗口
     */
    public static int maxFrequency2(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0, right = 1;
        int ans = 1;
        while (right < n) {
            int area = (nums[right] - nums[right - 1]) * (right - left);
            k -= area;
            if (k >= 0) {
                ans = right - left + 1;
            } else {
                left++;
                k += nums[right] - nums[left - 1];
            }
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3,6,9};
        int k = 2;
        System.out.println(maxFrequency(nums, k));
    }
}
