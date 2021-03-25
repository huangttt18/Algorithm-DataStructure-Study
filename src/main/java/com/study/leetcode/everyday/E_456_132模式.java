package com.study.leetcode.everyday;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 456. 132模式
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/24 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_456_132模式 {


    /**
     * 暴力贪心：保证3的左边的是最小的数
     * @param nums
     * @return
     */
    public static boolean find132pattern(int[] nums) {
        int min = nums[0];
        for (int j = 1; j < nums.length; j++) {
            for (int k = j + 1; k < nums.length; k++) {
                if (nums[k] < nums[j] && nums[k] > min) {
                    return true;
                }
            }
            min = Math.min(min, nums[j]);
        }
        return false;
    }

    public static boolean find132Pattern(int[] nums) {
        int length = nums.length;
        // mins数组：对于每一个索引i上的元素有mins[i] < mins[0，i)
        // 也就是说，mins[i]是从0到i之间的最小元素
        int[] mins = new int[length];
        mins[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            mins[i] = Math.min(mins[i - 1], nums[i]);

        // stack中存放的是[i, n)中，所有大于mins[i]且小于nums[i]的元素
        Deque<Integer> stack = new ArrayDeque<>();
        for (int j = length - 1; j >= 0; j--) {
            if (nums[j] > mins[j]) {
                // 此时保证了num[j] > 1(132中的1)
                // 接下来就要找到比min[j]大，但是比nums[j]小的数
                while (!stack.isEmpty() && stack.peek() <= mins[j])
                    stack.pop();
                if (!stack.isEmpty() && stack.peek() < nums[j])
                    // 此时表示找到了stack中大于mins[j]且小于nums[j]的数
                    // 也就是找到满足了132pattern的子序列
                    return true;
                stack.push(nums[j]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        int[] nums = {3, 1, 4, 2};
        int[] nums = {-2, 1, 2, -2, 1, 2};
        System.out.println(find132pattern(nums));
    }
}
