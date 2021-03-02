package com.study.leetcode.everyday;

/**
 * 303. 区域和检索 - 数组不可变
 * <p>
 * 给定一个整数数组 nums，求出数组从索引i到j（i≤j）范围内元素的总和，包含i、j两点。
 * <p>
 * 实现 NumArray 类：
 * <p>
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索引i到j（i≤j）范围内元素的总和，包含i、j两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/1 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_303_区域和检索_数组不可变 {

    public static void main(String[] args) {

    }

    /**
     * 解题思路：前缀和，即sums[i...j] = sums[j + 1](从[0...j]的所有数之和) - sums[i](从[0...i - 1]所有数之和)
     */
    class NumArray {

        /**
         * sums[i] = sums[i - 1] + nums[i - 1]
         */
        int[] sums;

        public NumArray(int[] nums) {
            sums = new int[nums.length + 1];
            for (int i = 1; i < sums.length; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }
        }

        /**
         * [i...j]的和，即sums[j + 1] - sums[i]
         *
         * @param i
         * @param j
         * @return
         */
        public int sumRange(int i, int j) {
            // sums[j]
            return sums[j + 1] - sums[i];
        }
    }
}
