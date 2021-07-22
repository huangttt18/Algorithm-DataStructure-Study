package com.study.leetcode.everyday;

import java.util.Arrays;

/**
 * 1818. 绝对差值和
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel - 2021/7/14</a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_1818_绝对差值和 {

    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        long ans = 0;
        long maxDiff = Integer.MIN_VALUE;
        int mod = 1000000007;
        int length = nums1.length;
        // 通过建立辅助数组并对其排序，采用二分查找，查找到对于每个i，与nums2[i]差值最小的nums[1]
        int[] aux = new int[length];
        System.arraycopy(nums1, 0, aux, 0, length);
        Arrays.sort(aux);
        for (int i = 0; i < length; i++) {
            // 对于每个i来说，差值为|nums1[i] - nums2[i]| => diff
            // 如果替换nums1[i]为j，那么其差值为|nums1[j] - nums2[i]|
            // 替换前后，差值为diff - |nums1[j] - nums2[i]|
            // 在i确定的情况下，我们只需要查找到j，使得|nums1[j] - nums2[i]|最大
            int diff = Math.abs(nums1[i] - nums2[i]);
            ans += diff;
            // 找到与nums2[i]最接近的num1中的值
            int j = bs(aux, nums2[i]);
            // 计算maxDiff
            if (j < length) {
                // 当j小于length时，计算当前MaxDiff
                maxDiff = Math.max(maxDiff, diff - (aux[j] - nums2[i]));
            }

            if (j > 0) {
                // 当j大于0时，计算当前MaxDiff
                maxDiff = Math.max(maxDiff, diff - (nums2[i] - aux[j - 1]));
            }
        }
        return (int) ((ans - maxDiff) % mod);
    }

    /**
     * 二分查找
     */
    public static int bs(int[] aux, int target) {
        int low = 0, high = aux.length - 1;
        if (aux[high] < target) {
            // 当target比aux最大值还大时，直接返回length
            return high + 1;
        }

        while (low < high) {
            int mid = (low + high) >>> 1;
            if (aux[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {

    }
}
