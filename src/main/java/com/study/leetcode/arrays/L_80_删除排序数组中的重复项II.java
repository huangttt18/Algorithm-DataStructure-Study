package com.study.leetcode.arrays;

/**
 * 80. 删除排序数组中的重复项 II
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/25 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class L_80_删除排序数组中的重复项II {

    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        int index = 0;
        int count = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] == nums[index]) {
                if (count < 2) {
                    // 需要将后面的元素移动到这里
                    nums[++index] = nums[i];
                    count++;
                }
            } else {
                nums[++index] = nums[i];
                count = 1;
            }
        }

        return index + 1;
    }

    public static void main(String[] args) {

    }
}
