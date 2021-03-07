package com.study.leetcode.everyday;

import com.study.common.util.CommonUtils;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503. 下一个更大元素 II
 *
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/3/6 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_503_下一个更大元素II {

    public static int[] nextGreaterElements(int[] nums) {
        // 注意考虑边界条件！！！！！！！！！！！！！！！！
        if (nums == null || nums.length == 0)
            return nums;
        if (nums.length == 1)
            return new int[] { -1};
        int[] ans = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int j;
            boolean flag = false;
            for (j = i; j != i - 1; ) {
                if (j + 1 >= nums.length && i != 0)
                    j = 0;
                else
                    j++;
                if (nums[j] > cur) {
                    ans[index++] = nums[j];
                    flag = true;
                    break;
                }
                if (j == nums.length - 1 && i == 0)
                    break;
            }
            if (nums[j] > cur)
                if (!flag)
                    ans[index++] = nums[j];
                else
                    flag = false;
            else
                ans[index++] = -1;
        }

        return ans;
    }

    /**
     * 单调递减栈解法：
     * 1. 栈中存放的是元素索引且从栈底到栈顶的元素值单调递减
     *      当我们查看某个元素时
     *          如果此时栈为空，那么将该元素的索引压栈
     *          如果此时栈不为空，那么将该元素和栈中元素依次做比较
     *              如果该元素大于栈顶元素，将栈顶元素(索引)出栈并且将元素赋值给对应索引位置，因此此时该元素时栈中元素的下一个最大元素
     *              如果该元素小于栈顶元素，将该元素入栈即可
     * 2.由于是循环数组，可能出现某个元素的下一个最大元素在该元素之前，因此我们需要将数组遍历两次
     *      针对于这个问题，我们可以将遍历的次数增加到原数组长度的两倍，每次对原数组长度[取模]即可得到当前索引在元素组中的值
     * 例如对于nums = [1, 2, 1]，stack = []，答案数组ans = [-1, -1, -1]，对于答案数组，我们赋予初始值-1，解决了某一个元素找不到下一个最大元素时为-1的情况
     * 第一次考察元素1(0)，此时stack是空的，push(0)
     * 接着看元素2(1)，此时stack不为空，并且nums[1] > nums[stack.peek()(0)]，因此我们给ans[stack.peek()(0)] = nums[1] = 2，同时stack.pop(0), stack.push(1)
     * stack = [1]
     * 接着看元素1(2)，此时stack不为空，并且nums[2] < nums[stack.peek()(1)]，push(2)
     * stack = [1, 2]
     * 接着看元素1(3 % 3(0))，此时stack不为空，并且nums[1] == nums[stack.peek()(2)]，push(0)
     * stack = [1, 2, 0]
     * 接着看元素2(4 % 3(1))，此时stack不为空，并且nums[1] > nums[stack.peek()(0)]，ans[stack.peek()(0)] = nums[1] = 2, stack.pop(0)
     * stack = [1, 2]
     * nums[1] > nums[stack.peek()(2)]，ans[stack.peek()(2)] = nums[1] = 2，stack.pop(2)
     * stack = [1]
     * ans[2, -1, 2]
     * nums[1] = nums[stack.peek()(1)]
     * 接着看元素1(5 % 3(2))，nums[2] < nums[stack.peek()(1)]，stack.push(2)
     * stack = [1, 2]
     * 此时遍历到索引位置6 == 2 * length(3)，遍历结束
     * 此时ans[2, -1, 2]就是最终答案
     * @param nums
     * @return
     */
    public static int[] nextGreaterElements2(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % length]) {
                ans[stack.pop()] = nums[i % length];
            }
            stack.push(i % length);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1};
//        int[] nums = {1, 2, 1};
//        int[] nums = {5, 4, 3, 2, 1};
        CommonUtils.printArray(nextGreaterElements(nums));
    }
}
