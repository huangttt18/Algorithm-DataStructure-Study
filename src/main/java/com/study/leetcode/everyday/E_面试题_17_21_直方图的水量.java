package com.study.leetcode.everyday;

/**
 * 面试题 17.21. 直方图的水量
 *
 * @author <a href="mailto:danielhuang9618@gmail.com"> Daniel on 2021/4/2 </a>
 * @since <span>1.0</span>
 */
@SuppressWarnings("all")
public class E_面试题_17_21_直方图的水量 {

    /**
     * 双指针
     *  按高度遍历：从第一层到第N层，直到两个指针相遇，表示再上一层已经无法装水了
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int ans = 0, total = sum(height), high = 1;
        int length = height.length;

        int left = 0, right = length - 1;
        while (left <= right) {
            while (left <= right && height[left] < high)
                left++;
            while (left <= right && height[right] < high)
                right--;
            ans += right - left + 1;
            high++;
        }
        ans -= total;
        return ans;
    }

    /**
     * 动态规划: 保存每个索引i，左边最大maxLeft的和右边最大的maxRight
     *  求maxLeft和maxRight之间最小的值min然后和当前元素i进行比较
     *      1. 如果 min < i，那么当前位置i不能装水
     *      2. 如果 min > i，那么当前位置可以装下min - i体积的水
     *      3. 如果 min == i，那么当前位置i不能装水
     * @param height
     * @return
     */
    public static int trap2(int[] height) {
        int ans = 0;
        int length = height.length;
        // dpMaxLeft[i] = max(dpMaxLeft[i - 1], height[i - 1])，当前元素之前的最大的元素，不包括当前元素
        int[] dpMaxLeft = new int[length];
        // dpMaxRight[i] = max(dpMaxRight[i + 1], height[i + 1])，当前元素之后的最大元素，不包括当前元素
        int[] dpMaxRight = new int[length];
        // 从第1个位置开始考虑，因为边界元素一定是不能装水的
        for (int i = 1; i <= length - 2; i++) {
            dpMaxLeft[i] = Math.max(dpMaxLeft[i - 1], height[i - 1]);
        }

        for (int i = length - 2; i >= 0; i--) {
            dpMaxRight[i] = Math.max(height[i + 1], dpMaxRight[i + 1]);
        }

        for (int i = 1; i <= length - 2; i++) {
            int min = Math.min(dpMaxLeft[i], dpMaxRight[i]);
            if (min > height[i])
                ans += min - height[i];
        }

        return ans;
    }



    private static int sum(int[] height) {
        int ret = 0;
        for (int i : height) {
            ret += i;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
